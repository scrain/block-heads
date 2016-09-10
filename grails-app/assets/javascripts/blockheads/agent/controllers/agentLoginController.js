angular
    .module("blockheads.agent")
    .controller("AgentLoginController", AgentLoginController);

function AgentLoginController(Agent, $stateParams, $state) {
     var vm = this;
    vm.agent = new Agent();
    var max = 1000, offset = 0;

    vm.loginAgent = function() {
        vm.errors = undefined;
        Agent.list({max: max, offset: offset}, function(data) {
            angular.forEach(data, function(item){
                if (vm.agent.email.toLowerCase() == item.email.toLowerCase() && vm.agent.password.toLowerCase() == item.password.toLowerCase() ){
                    $state.go('agent.show', {id: item.id});
                }
            })
        });
        $state.go('agent.login');
    };
}
