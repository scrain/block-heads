//= wrapped

angular
    .module("blockheads.transaction")
    .controller("TransactionListController", TransactionListController);

function TransactionListController(Transaction) {
    var vm = this;

    var max = 10, offset = 0;

    Transaction.list({max: max, offset: offset}, function(data) {
        vm.transactionList = data;
    });
}
