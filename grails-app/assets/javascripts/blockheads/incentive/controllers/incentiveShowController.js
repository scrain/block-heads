//= wrapped

angular
    .module("blockheads.incentive")
    .controller("IncentiveShowController", IncentiveShowController);

function IncentiveShowController(Incentive, $stateParams, $state) {
    var vm = this;

    Incentive.get({id: $stateParams.id}, function(data) {
        vm.incentive = new Incentive(data);
    }, function() {
        $state.go('incentive.list');
    });

    vm.delete = function() {
        vm.incentive.$delete(function() {
            $state.go('incentive.list');
        }, function() {
            //on error
        });
    };

}
