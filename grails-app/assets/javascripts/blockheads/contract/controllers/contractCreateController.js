//= wrapped

angular
    .module("blockheads.contract")
    .controller("ContractCreateController", ContractCreateController);

function ContractCreateController(Contract, $state) {

    var vm = this;
    
    vm.contract = new Contract();
    
    vm.saveContract = function() {
        vm.errors = undefined;
        vm.contract.$save({}, function() {
            $state.go('contract.show', {id: vm.contract.id});
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
