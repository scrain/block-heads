//= wrapped
//= require /angular/angular-resource

angular
    .module("blockheads.incentive")
    .factory("Incentive", Incentive);

function Incentive($resource) {
    var Incentive = $resource(
        "incentive/:id",
        {"id": "@id"},
        {"update": {method: "PUT"},
         "query": {method: "GET", isArray: true},
         "get": {method: 'GET'}}
    );

    Incentive.list = Incentive.query;

    Incentive.prototype.toString = function() {
        // return 'blockheads.Incentive : ' + (this.id ? this.id : '(unsaved)');
        return this.name;
    };

    return Incentive;
}
