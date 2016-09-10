//= wrapped

angular
    .module("blockheads.agent")
    .controller("AgentListController", AgentListController);

function AgentListController(Agent) {
    var vm = this;

    var max = 1000, offset = 0;

    Agent.list({max: max, offset: offset}, function(data) {
        vm.agentList = data;
    });
}
