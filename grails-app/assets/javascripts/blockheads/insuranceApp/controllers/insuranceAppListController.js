//= wrapped

angular
    .module("blockheads.insuranceApp")
    .controller("InsuranceAppListController", InsuranceAppListController);

function InsuranceAppListController(InsuranceApp) {
    var vm = this;

    var max = 10, offset = 0;

    InsuranceApp.list({max: max, offset: offset}, function(data) {
        vm.insuranceAppList = data;
    });
}
