//= wrapped
//= require /angular/angular-resource

angular
    .module("blockheads.contract")
    .factory("Contract", Contract);

function Contract($resource) {
    var Contract = $resource(
        "contract/:id",
        {"id": "@id"},
        {"update": {method: "PUT"},
         "query": {method: "GET", isArray: true},
         "get": {method: 'GET'}}
    );

    Contract.list = Contract.query;

    Contract.prototype.toString = function() {
        return 'blockheads.Contract : ' + (this.id ? this.id : '(unsaved)');
    };

    return Contract;
}
