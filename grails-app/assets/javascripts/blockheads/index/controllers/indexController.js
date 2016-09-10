//= wrapped

angular
    .module("blockheads.index")
    .controller("IndexController", IndexController);

function IndexController(applicationDataFactory, contextPath, Agent, $state) {
    var vm = this;

    vm.contextPath = contextPath;

    applicationDataFactory.get().then(function(response) {
        vm.applicationData = response.data;
    });

    vm.stateExists = function(name) {
        return $state.get(name) != null;
    };

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
