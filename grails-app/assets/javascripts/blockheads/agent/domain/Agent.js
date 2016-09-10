//= wrapped
//= require /angular/angular-resource

angular
    .module("blockheads.agent")
    .factory("Agent", Agent);

function Agent($resource, domainListConversion, domainConversion, domainToManyConversion) {
    var Agent = $resource(
        "agent/:id",
        {"id": "@id"},
        {
            "update": {method: "PUT"},
            "query": {
                method: "GET",
                isArray: true,
                transformResponse: [angular.fromJson, domainListConversion("State", "state", "domainConversion"), domainListConversion("State", "licenseStates", "domainToManyConversion"), domainListConversion("Contract", "contract", "domainConversion"), domainListConversion("Incentive", "incentives", "domainToManyConversion"), domainListConversion("Transaction", "transactions", "domainToManyConversion")]
            },
            "get": {
                method: 'GET',
                transformResponse: [angular.fromJson, domainConversion("State", "state"), domainToManyConversion("State", "licenseStates"), domainConversion("Contract", "contract"), domainToManyConversion("Incentive", "incentives"), domainToManyConversion("Transaction", "transactions")]
            }
        }
    );

    Agent.list = Agent.query;

    Agent.prototype.toString = function () {
        return this.lastName + ", " + this.firstName;
    };

    Agent.prototype.contractPremium = function () {
        var total = -1; // TODO: hack
        if ( this.contract.name === '55K for two years' ) {
            total = 55000 * 2;
        } else if ( this.contract.name === '36K for three years' ) {
            total = 36000 * 3;
        } else if ( this.contract.name === '23K for five years' ) {
            total = 23000 * 5;
        }
        return total;
    };

    Agent.prototype.contractPremiumPerPeriod = function () {
        var total = -1; // TODO: hack
        if ( this.contract.name === '55K for two years' ) {
            total = 55000;
        } else if ( this.contract.name === '36K for three years' ) {
            total = 36000;
        } else if ( this.contract.name === '23K for five years' ) {
            total = 23000;
        }
        return total;
    };

    Agent.prototype.contractPremiumComplete = function () {
        var total = 0;
        for (var i = 0; i < this.transactions.length; i++) {
            if (this.transactions[i].status === 'complete') {
                total += this.transactions[i].premium;
            }
        }
        return total;
    };

    Agent.prototype.contractPremiumPercentComplete = function () {
        return Math.round( (this.contractPremiumComplete() / this.contractPremium())*100);
    };

    Agent.prototype.contractPremiumPending = function () {
        var total = 0;
        for (var i = 0; i < this.transactions.length; i++) {
            if (this.transactions[i].status === 'pending') {
                total += this.transactions[i].premium;
            }
        }
        return total;
    };

    Agent.prototype.contractPremiumPercentPending = function () {
        return Math.round( (this.contractPremiumPending() / this.contractPremium())*100);
    };

    Agent.prototype.contractEndDate = function () {
        var d = new Date(this.contractDate.getTime());

        d.setDate( d.getDate() + this.contractDays())

        return d;
    };

    /**
        Methods for calculations for current period only
     **/
    Agent.prototype.contractCurrentPeriodStart = function () {
        var startDate = new Date(this.contractDate.getTime());
        var endDate   = this.contractEndDate();
        var today     = new Date();

        if ( today > endDate ) {
            endDate.setDate(endDate.getDate() - 365);
            return endDate;
        }
        if ( today < startDate ) {
            return startDate;
        }
        var daysIntoCurrentPeriod = daysBetween(startDate, today) % 365;

        today.setDate(today.getDate() - daysIntoCurrentPeriod);

        return today;
    };

    Agent.prototype.contractCurrentPeriodEnd = function () {
        var startDate = new Date(this.contractDate.getTime());
        var endDate   = this.contractEndDate();
        var today     = new Date();

        if ( today > endDate ) {
            return endDate;
        }
        if ( today < startDate ) {
            startDate.setDate(startDate.getDate() + 365);
        }

        var daysFromCurrentPeriodEnd = daysBetween(endDate, today) % 365;
        endDate.setDate(endDate.getDate() - daysFromCurrentPeriodEnd);
        return endDate;
    };

    Agent.prototype.contractPremiumCompleteCurrentPeriod = function () {
        var total = 0;
        var periodStart = this.contractCurrentPeriodStart();
        var periodEnd   = this.contractCurrentPeriodEnd();

        for (var i = 0; i < this.transactions.length; i++) {

            if ( periodEnd > this.transactions[i].dateCreated  && this.transactions[i].dateCreated > periodStart ) {
                if (this.transactions[i].status === 'complete') {
                    total += this.transactions[i].premium;
                }
            }
        }
        return total;
    };

    Agent.prototype.contractPremiumPendingCurrentPeriod = function () {
        var total = 0;
        var periodStart = this.contractCurrentPeriodStart();
        var periodEnd   = this.contractCurrentPeriodEnd();

        for (var i = 0; i < this.transactions.length; i++) {

            if ( periodEnd > this.transactions[i].dateCreated  && this.transactions[i].dateCreated > periodStart ) {
                if (this.transactions[i].status === 'pending') {
                    total += this.transactions[i].premium;
                }
            }
        }
        return total;
    };

    Agent.prototype.contractPremiumPercentCompleteCurrentPeriod = function () {
        return Math.round( (this.contractPremiumCompleteCurrentPeriod() / this.contractPremiumPerPeriod())*100);
    };

    Agent.prototype.contractPremiumPendingCurrentPeriod = function () {
        var total = 0;
        for (var i = 0; i < this.transactions.length; i++) {
            if (this.transactions[i].status === 'pending') {
                total += this.transactions[i].premium;
            }
        }
        return total;
    };

    Agent.prototype.contractPremiumPercentPendingCurrentPeriod = function () {
        return Math.round( (this.contractPremiumPendingCurrentPeriod() / this.contractPremiumPerPeriod())*100);
    };

    Agent.prototype.contractPercentCurrentPeriod = function () {
        if ( today > this.contractCurrentPeriodEnd() ) {
            return 100;
        }
        if ( this.contractCurrentPeriodStart() > today) {
            return 0;
        }

        var totalDays = 365;  // TODO: all periods are annual currently

        var today = new Date();

        var daysElapsed = daysBetween(this.contractCurrentPeriodStart(), today);

        var percent =  Math.floor(( daysElapsed / totalDays ) * 100);

        return percent;
    };

    Agent.prototype.contractPercent = function () {
        if ( today > this.contractCurrentPeriodEnd() ) {
            return 100;
        }
        if ( this.contractCurrentPeriodStart() > today) {
            return 0;
        }

        var totalDays = this.contractDays();

        var today = new Date();

        var daysElapsed = daysBetween(this.contractDate, today);

        var percent =  Math.round(( daysElapsed / totalDays ) * 100);

        return percent;
    };

    Agent.prototype.contractMonthsElapsed = function () {
        return Math.floor( contractMonths() * (this.contractPercent()/100.0) )
    };

    Agent.prototype.contractMonths = function () {
        return Math.ceil( contractMonths() * ( (100.0-this.contractPercent())/100.0) )
    };

    Agent.prototype.contractMonthsElapsedCurrentPeriod = function () {
        return Math.floor( 12.0 * (this.contractPercentCurrentPeriod()/100.0) )
    };

    Agent.prototype.contractMonthsRemainingCurrentPeriod = function () {
        return Math.ceil( 12.0 * ( (100.0-this.contractPercentCurrentPeriod())/100.0) )
    };

    Agent.prototype.contractMonths = function () {
        var totalMonths = 12; // TODO: hack
        if ( this.contract.term === '2 year' ) {
            totalMonths *= 2;
        } else if ( this.contract.term === '3 year' ) {
            totalMonths *= 3;
        } else if ( this.contract.term === '5 year' ) {
            totalMonths *= 5;
        }
        return totalMonths;
    };

    Agent.prototype.contractMonthsElapsed = function () {
        var today = new Date();

        var months;

        months = (today.getFullYear() - this.contractDate.getFullYear()) * 12;
        months -= this.contractDate.getMonth() + 1;
        months += today.getMonth();

        return months <= 0 ? 0 : months;
    };

    Agent.prototype.contractMonthsRemaining = function () {
        return this.contractMonths() - this.contractMonthsElapsed();
    };

    Agent.prototype.contractDays = function () {
        var totalDays = 365; // TODO: hack
        if ( this.contract.term === '2 year' ) {
            totalDays *= 2;
        } else if ( this.contract.term === '3 year' ) {
            totalDays *= 3;
        } else if ( this.contract.term === '5 year' ) {
            totalDays *= 5;
        }
        return totalDays;
    };


    Agent.prototype.contractPercent = function () {
        var totalDays = this.contractDays();

        var today = new Date();

        var daysElapsed = daysBetween(this.contractDate, today);

        var percent =  Math.round(( daysElapsed / totalDays ) * 100);

        return percent;
    };

    return Agent;

    function daysBetween( start, end ) {
        var startDate = new Date(start);
        var endDate = new Date(end);

        var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds

        return Math.round(Math.abs((endDate.getTime() - startDate.getTime())/(oneDay)));
    }
}
