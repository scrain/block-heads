//= wrapped

angular
    .module("blockheads.insuranceApp")
    .controller("InsuranceAppCreateController", InsuranceAppCreateController);

function InsuranceAppCreateController(InsuranceApp, $state, contractService) {
    function getRandomArbitrary(min, max) {
        min = Math.ceil(min);
        max = Math.floor(max);
        return Math.floor(Math.random() * (max - min)) + min;
    }

    var planTypes = ['Term', 'foo']
    var firstNames =['Brian', 'Praveen', 'Caroline', 'Shawn', 'Jeff', 'Andrey', 'Mark', 'Jym', 'Peter'];
    var lastNames =['Johnson', 'Smith', 'Funny', 'Sunshine', 'Blockhead', 'Kota', 'Compton', 'Crain', 'Specter', 'Simpsons'];
    var statuses = ['pending', 'issued', 'declined'];

    function getInsuranceApp() {
        var insuranceApp = new InsuranceApp();
        insuranceApp.number = 'App_Num_' + getRandomArbitrary(1, 6000);
        insuranceApp.faceAmount = getRandomArbitrary(2, 200) * 50000;
        insuranceApp.premium = insuranceApp.faceAmount * .002;
        insuranceApp.planType = planTypes[getRandomArbitrary(0, planTypes.length - 1)];
        insuranceApp.insuredName = firstNames[getRandomArbitrary(0, firstNames.length - 1)] + ' ' + lastNames[getRandomArbitrary(0, lastNames.length - 1)];
        insuranceApp.status = statuses[getRandomArbitrary(0, statuses.length)];
        if (insuranceApp.status !== 'pending') {
            insuranceApp.issueDate = new Date();
        }
        return insuranceApp;
    }
    var vm = this;
    
    vm.insuranceApp = getInsuranceApp();

    /**
     * Steps:
     *  Update block chain
     *      to pending --> addToPending
     *      from pending --> removeFromPending
     *      to complete --> addToInforce
     *      from compete --> removeFromInforce
     *  Create Tranasaction record (summary of result)
     *  Save the InsuranceApp
     *
     */
    vm.saveInsuranceApp = function() {
        vm.errors = undefined;

        vm.insuranceApp.$save({}, function() {
            $state.go('insuranceApp.show', {id: vm.insuranceApp.id});
        }, function(response) {
            var data = response.data;
            if (data.hasOwnProperty('message')) {
                vm.errors = [data];
            } else {
                vm.errors = data._embedded.errors;
            }
        });
    };




    vm.saveInsuranceApp = function() {
        vm.errors = undefined;
        var saveToServer  = function(contract) {
            vm.insuranceApp.$save({}, function() {
                $state.go('insuranceApp.show', {id: vm.insuranceApp.id});
            }, function(response) {
                var data = response.data;
                if (data.hasOwnProperty('message')) {
                    vm.errors = [data];
                } else {
                    vm.errors = data._embedded.errors;
                }
            });
        };

        var transactionCompleteCb = function(err, myContract){
            if(!err) {
                if(myContract.address) {
                    console.log('address ='+ myContract.address) // the contract address
                    vm.agent.contractAddress = myContract.address;
                    saveToServer();
                } else {
                    console.log(myContract.transactionHash) // The hash of the transaction, which deploys the contract
                }
            } else {
                console.log(err);
            }
        };

        // create new blockchain contract
        contractService.updateAgentOffer(vm.insuranceApp, transactionCompleteCb);

    };
}
