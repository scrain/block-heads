//= wrapped

angular
    .module("blockheads.agent")
    .controller("AgentCreateController", AgentCreateController);

function AgentCreateController(Agent, $state, State, Contract, Incentive, Transaction, contextPath) {

    var vm = this;
    vm.contextPath = contextPath
    vm.stateList = State.list();
    vm.contractList = Contract.list();
    vm.incentiveList = Incentive.list();
    vm.transactionList = Transaction.list();
    vm.agent = new Agent();
    
    vm.saveAgent = function() {
        vm.errors = undefined;
        vm.agent.$save({}, function() {
            $state.go('agent.edit', {id: vm.agent.id});
        }, function(response) {
            var data = response.data;
            if (data.hasOwnProperty('message')) {
                vm.errors = [data];
            } else {
                vm.errors = data._embedded.errors;
            }
        });
    };
}
