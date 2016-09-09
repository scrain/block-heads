//= wrapped

angular
    .module("blockheads.incentive")
    .controller("IncentiveEditController", IncentiveEditController);

function IncentiveEditController(Incentive, $stateParams, $state) {
    var vm = this;

    

    Incentive.get({id: $stateParams.id}, function(data) {
        vm.incentive = new Incentive(data);
    }, function() {
        vm.errors = [{message: "Could not retrieve incentive with ID " + $stateParams.id}];
    });

    vm.updateIncentive = function() {
        vm.errors = undefined;
        vm.incentive.$update(function() {
            $state.go('incentive.show', {id: vm.incentive.id});
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
