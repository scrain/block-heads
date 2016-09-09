//= wrapped
//= require /angular/angular-resource

angular
    .module("blockheads.agent")
    .factory("Agent", Agent);

function Agent($resource, domainListConversion, domainConversion, domainToManyConversion) {
    var Agent = $resource(
        "agent/:id",
        {"id": "@id"},
        {"update": {method: "PUT"},
         "query": {method: "GET", isArray: true, transformResponse: [angular.fromJson, domainListConversion("State", "state", "domainConversion"), domainListConversion("State", "licenseStates", "domainToManyConversion"), domainListConversion("Contract", "contract", "domainConversion"), domainListConversion("Incentive", "incentives", "domainToManyConversion"), domainListConversion("Transaction", "transactions", "domainToManyConversion")]},
         "get": {method: 'GET', transformResponse: [angular.fromJson, domainConversion("State", "state"), domainToManyConversion("State", "licenseStates"), domainConversion("Contract", "contract"), domainToManyConversion("Incentive", "incentives"), domainToManyConversion("Transaction", "transactions")]}}
    );

    Agent.list = Agent.query;

    Agent.prototype.toString = function() {
        // return 'blockheads.Agent : ' + (this.id ? this.id : '(unsaved)');
        return this.lastName + ", " + firstName;
    };

    return Agent;
}
