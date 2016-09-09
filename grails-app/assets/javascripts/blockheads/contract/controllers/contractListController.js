//= wrapped

angular
    .module("blockheads.contract")
    .controller("ContractListController", ContractListController);

function ContractListController(Contract) {
    var vm = this;

    var max = 10, offset = 0;

    Contract.list({max: max, offset: offset}, function(data) {
        vm.contractList = data;
    });
}
