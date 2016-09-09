//= wrapped

angular
    .module("blockheads.agent")
    .controller("AgentEditController", AgentEditController);

function AgentEditController(Agent, $stateParams, $state, State, Contract, Incentive, Transaction) {
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
}
