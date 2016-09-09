//= wrapped

angular
    .module("blockheads.state")
    .controller("StateEditController", StateEditController);

function StateEditController(State, $stateParams, $state) {
    var vm = this;

    

    State.get({id: $stateParams.id}, function(data) {
        vm.state = new State(data);
    }, function() {
        vm.errors = [{message: "Could not retrieve state with ID " + $stateParams.id}];
    });

    vm.updateState = function() {
        vm.errors = undefined;
        vm.state.$update(function() {
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
