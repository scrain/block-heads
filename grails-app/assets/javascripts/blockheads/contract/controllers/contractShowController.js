//= wrapped

angular
    .module("blockheads.contract")
    .controller("ContractShowController", ContractShowController);

function ContractShowController(Contract, $stateParams, $state) {
    var vm = this;

    Contract.get({id: $stateParams.id}, function(data) {
        vm.contract = new Contract(data);
    }, function() {
        $state.go('contract.list');
    });

    vm.delete = function() {
        vm.contract.$delete(function() {
            $state.go('contract.list');
        }, function() {
            //on error
        });
    };

}
