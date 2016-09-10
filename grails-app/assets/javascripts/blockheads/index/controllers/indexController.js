//= wrapped

angular
    .module("blockheads.index")
    .controller("IndexController", IndexController);

function IndexController(applicationDataFactory, contextPath, Agent, $state) {
    var vm = this;

    vm.contextPath = contextPath;
    var max = 1000, offset = 0;

    applicationDataFactory.get().then(function(response) {
        vm.applicationData = response.data;
    });

    vm.stateExists = function(name) {
        return $state.get(name) != null;
    };

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

    vm.agentlogin = new Agent();
    vm.loginAgent = function() {
        vm.errors = undefined;
        Agent.list({max: max, offset: offset}, function(data) {
            angular.forEach(data, function(item){
                if (vm.agentlogin.email.toLowerCase() == item.email.toLowerCase() && vm.agentlogin.password.toLowerCase() == item.password.toLowerCase() ){
                    $state.go('agent.show', {id: item.id});
                }
            })
            vm.loginerrors=[{message:'login failed, try again!'}];
        });

    };
}
