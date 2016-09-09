//= wrapped

angular
    .module("blockheads.state")
    .controller("StateShowController", StateShowController);

function StateShowController(State, $stateParams, $state) {
    var vm = this;

    State.get({id: $stateParams.id}, function(data) {
        vm.state = new State(data);
    }, function() {
        $state.go('state.list');
    });

    vm.delete = function() {
        vm.state.$delete(function() {
            $state.go('state.list');
        }, function() {
            //on error
        });
    };

}
