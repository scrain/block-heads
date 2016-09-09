//= wrapped

angular
    .module("blockheads.transaction")
    .controller("TransactionShowController", TransactionShowController);

function TransactionShowController(Transaction, $stateParams, $state) {
    var vm = this;

    Transaction.get({id: $stateParams.id}, function(data) {
        vm.transaction = new Transaction(data);
    }, function() {
        $state.go('transaction.list');
    });

    vm.delete = function() {
        vm.transaction.$delete(function() {
            $state.go('transaction.list');
        }, function() {
            //on error
        });
    };

}
