//= wrapped
//= require /angular/angular-resource

angular
    .module("blockheads.insuranceApp")
    .factory("InsuranceApp", InsuranceApp);

function InsuranceApp($resource) {
    var InsuranceApp = $resource(
        "insuranceApp/:id",
        {"id": "@id"},
        {"update": {method: "PUT"},
         "query": {method: "GET", isArray: true},
         "get": {method: 'GET'}}
    );

    InsuranceApp.list = InsuranceApp.query;

    InsuranceApp.prototype.toString = function() {
        // return 'blockheads.InsuranceApp : ' + (this.id ? this.id : '(unsaved)');
        return this.number;
    };

    return InsuranceApp;
}
