//= wrapped
//= require /angular/angular-resource

angular
    .module("blockheads.transaction")
    .factory("Transaction", Transaction);

function Transaction($resource) {
    var Transaction = $resource(
        "transaction/:id",
        {"id": "@id"},
        {"update": {method: "PUT"},
         "query": {method: "GET", isArray: true},
         "get": {method: 'GET'}}
    );

    Transaction.list = Transaction.query;

    Transaction.prototype.toString = function() {
        return 'blockheads.Transaction : ' + (this.id ? this.id : '(unsaved)');
    };

    return Transaction;
}
