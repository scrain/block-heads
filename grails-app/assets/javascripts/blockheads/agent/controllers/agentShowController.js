//= wrapped

angular
    .module("blockheads.agent")
    .controller("AgentShowController", AgentShowController);

function AgentShowController(Agent, $stateParams, $state) {
    var vm = this;

    Agent.get({id: $stateParams.id}, function(data) {
        vm.agent = new Agent(data);
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
