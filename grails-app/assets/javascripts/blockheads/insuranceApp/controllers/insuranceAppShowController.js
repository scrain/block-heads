//= wrapped

angular
    .module("blockheads.insuranceApp")
    .controller("InsuranceAppShowController", InsuranceAppShowController);

function InsuranceAppShowController(InsuranceApp, $stateParams, $state) {
    var vm = this;

    InsuranceApp.get({id: $stateParams.id}, function(data) {
        vm.insuranceApp = new InsuranceApp(data);
    }, function() {
        $state.go('insuranceApp.list');
    });

    vm.delete = function() {
        vm.insuranceApp.$delete(function() {
            $state.go('insuranceApp.list');
        }, function() {
            //on error
        });
    };

}
