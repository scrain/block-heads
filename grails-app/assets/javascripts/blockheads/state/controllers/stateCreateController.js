//= wrapped

angular
    .module("blockheads.state")
    .controller("StateCreateController", StateCreateController);

function StateCreateController(State, $state) {

    var vm = this;
    
    vm.state = new State();
    
    vm.saveState = function() {
        vm.errors = undefined;
        vm.state.$save({}, function() {
            $state.go('state.show', {id: vm.state.id});
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
