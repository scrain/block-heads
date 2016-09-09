//= wrapped

angular
    .module("blockheads.insuranceApp")
    .controller("InsuranceAppEditController", InsuranceAppEditController);

function InsuranceAppEditController(InsuranceApp, $stateParams, $state) {
    var vm = this;

    

    InsuranceApp.get({id: $stateParams.id}, function(data) {
        vm.insuranceApp = new InsuranceApp(data);
    }, function() {
        vm.errors = [{message: "Could not retrieve insuranceApp with ID " + $stateParams.id}];
    });

    vm.updateInsuranceApp = function() {
        vm.errors = undefined;
        vm.insuranceApp.$update(function() {
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
