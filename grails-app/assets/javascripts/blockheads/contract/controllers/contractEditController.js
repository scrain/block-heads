//= wrapped

angular
    .module("blockheads.contract")
    .controller("ContractEditController", ContractEditController);

function ContractEditController(Contract, $stateParams, $state) {
    var vm = this;

    

    Contract.get({id: $stateParams.id}, function(data) {
        vm.contract = new Contract(data);
    }, function() {
        vm.errors = [{message: "Could not retrieve contract with ID " + $stateParams.id}];
    });

    vm.updateContract = function() {
        vm.errors = undefined;
        vm.contract.$update(function() {
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
