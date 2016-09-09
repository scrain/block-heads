//= wrapped

angular
    .module("blockheads.agent")
    .controller("AgentEditController", AgentEditController);

function AgentEditController(Agent, $stateParams, $state, $q, State, Contract, Incentive, Transaction, contractService) {
    var vm = this;

    vm.stateList = State.list();
    vm.contractList = Contract.list();
    vm.incentiveList = Incentive.list();
    vm.transactionList = Transaction.list();

    Agent.get({id: $stateParams.id}, function(data) {
        vm.agent = new Agent(data);
    }, function() {
        vm.errors = [{message: "Could not retrieve agent with ID " + $stateParams.id}];
    });

    vm.updateAgent = function() {
        vm.errors = undefined;
        var updateServer  = function(contract) {
            if (contract && contract.name != 'none') {
                vm.agent.contractAddress = contract.address;
            }
            vm.agent.$update(function() {
                $state.go('agent.show', {id: vm.agent.id});
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
                    updateServer();
                } else {
                    console.log(myContract.transactionHash) // The hash of the transaction, which deploys the contract
                }
            } else {
                console.log(err);
            }
        };

        if (vm.agent.contract && !vm.agent.contractAddress) {
            // create new blockchain contract
            contractService.createAgentOffer(vm.agent.contract, transactionCompleteCb);
        } else {
            updateServer();
        }


    };
}
