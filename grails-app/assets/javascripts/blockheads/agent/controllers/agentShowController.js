//= wrapped

angular
    .module("blockheads.agent")
    .controller("AgentShowController", AgentShowController);

function AgentShowController(Agent, $stateParams, $state, contractService) {
    var vm = this;

    Agent.get({id: $stateParams.id}, function(data) {
        vm.agent = new Agent(data);
        if (vm.agent.contractAddress) {
            vm.contract = contractService.getAgentOffer(vm.agent.contractAddress);
            console.log('retrieved contract : ' + vm.contract.getName());
            console.log('  date: '+ vm.contract.getInstatedDate());
            console.log('  pending: '+ vm.contract.getPendingAmount());
            console.log('  inforcedAmount: '+ vm.contract.getAmount());
            console.log('  maxPayout: '+ vm.contract.getMaxPayout());
        }

    }, function() {
        $state.go('agent.list');
    });

    vm.delete = function() {
        vm.agent.$delete(function() {
            $state.go('agent.list');
        }, function() {
            //on error
        });
    };

}
