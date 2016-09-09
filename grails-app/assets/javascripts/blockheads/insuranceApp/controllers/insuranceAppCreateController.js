//= wrapped

angular
    .module("blockheads.insuranceApp")
    .controller("InsuranceAppCreateController", InsuranceAppCreateController);

function InsuranceAppCreateController(InsuranceApp, $state) {

    var vm = this;
    
    vm.insuranceApp = new InsuranceApp();
    
    vm.saveInsuranceApp = function() {
        vm.errors = undefined;
        vm.insuranceApp.$save({}, function() {
            $state.go('insuranceApp.show', {id: vm.insuranceApp.id});
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
