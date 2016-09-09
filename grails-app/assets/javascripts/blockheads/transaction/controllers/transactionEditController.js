//= wrapped

angular
    .module("blockheads.transaction")
    .controller("TransactionEditController", TransactionEditController);

function TransactionEditController(Transaction, $stateParams, $state) {
    var vm = this;

    

    Transaction.get({id: $stateParams.id}, function(data) {
        vm.transaction = new Transaction(data);
    }, function() {
        vm.errors = [{message: "Could not retrieve transaction with ID " + $stateParams.id}];
    });

    vm.updateTransaction = function() {
        vm.errors = undefined;
        vm.transaction.$update(function() {
            $state.go('transaction.show', {id: vm.transaction.id});
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
