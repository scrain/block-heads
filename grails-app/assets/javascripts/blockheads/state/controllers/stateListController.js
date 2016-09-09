//= wrapped

angular
    .module("blockheads.state")
    .controller("StateListController", StateListController);

function StateListController(State) {
    var vm = this;

    var max = 10, offset = 0;

    State.list({max: max, offset: offset}, function(data) {
        vm.stateList = data;
    });
}
