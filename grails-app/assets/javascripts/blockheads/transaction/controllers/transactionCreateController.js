//= wrapped

angular
    .module("blockheads.transaction")
    .controller("TransactionCreateController", TransactionCreateController);

function TransactionCreateController(Transaction, $state) {

    var vm = this;
    
    vm.transaction = new Transaction();
    
    vm.saveTransaction = function() {
        vm.errors = undefined;
        vm.transaction.$save({}, function() {
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
