//= wrapped

angular
    .module("blockheads.incentive")
    .controller("IncentiveListController", IncentiveListController);

function IncentiveListController(Incentive) {
    var vm = this;

    var max = 1000, offset = 0;

    Incentive.list({max: max, offset: offset}, function(data) {
        vm.incentiveList = data;
    });
}
