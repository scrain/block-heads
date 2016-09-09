//= wrapped
//= require /angular/angular-resource

angular
    .module("blockheads.state")
    .factory("State", State);

function State($resource) {
    var State = $resource(
        "state/:id",
        {"id": "@id"},
        {"update": {method: "PUT"},
         "query": {method: "GET", isArray: true},
         "get": {method: 'GET'}}
    );

    State.list = State.query;

    State.prototype.toString = function() {
        return 'blockheads.State : ' + (this.id ? this.id : '(unsaved)');
    };

    return State;
}
