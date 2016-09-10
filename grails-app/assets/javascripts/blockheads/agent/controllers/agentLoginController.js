
angular
    .module("blockheads.agent")
    .controller("AgentLoginController", AgentLoginController);

function AgentLoginController(Agent, $stateParams, $state) {
    var vm = this;
    vm.agent = new Agent();

    vm.loginAgent = function() {
        $state.go('agent.show');
    };

}
