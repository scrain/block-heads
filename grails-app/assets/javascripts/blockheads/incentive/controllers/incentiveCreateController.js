//= wrapped

angular
    .module("blockheads.incentive")
    .controller("IncentiveCreateController", IncentiveCreateController);

function IncentiveCreateController(Incentive, $state) {

    var vm = this;
    
    vm.incentive = new Incentive();
    
    vm.saveIncentive = function() {
        vm.errors = undefined;
        vm.incentive.$save({}, function() {
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
