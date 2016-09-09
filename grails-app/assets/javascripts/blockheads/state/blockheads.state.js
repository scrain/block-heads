//= wrapped
//= require /angular/angular 
//= require /angular/angular-ui-router
//= require /angular/angular-resource
//= require /blockheads/core/blockheads.core
//= require_self
//= require_tree services
//= require_tree controllers
//= require_tree directives
//= require_tree domain
//= require_tree templates

angular.module("blockheads.state", ["ui.router", "ngResource", "blockheads.core"]).config(config);

function config($stateProvider) {
    $stateProvider
        .state('state', {
            url: "/state",
            abstract: true,
            template: "<div ui-view></div>"
        })
        .state('state.list', {
            url: "",
            templateUrl: "/blockheads/state/list.html",
            controller: "StateListController as vm"
        })
        .state('state.create', {
            url: "/create",
            templateUrl: "/blockheads/state/create.html",
            controller: "StateCreateController as vm"
        })
        .state('state.edit', {
            url: "/edit/:id",
            templateUrl: "/blockheads/state/edit.html",
            controller: "StateEditController as vm"
        })
        .state('state.show', {
            url: "/show/:id",
            templateUrl: "/blockheads/state/show.html",
            controller: "StateShowController as vm"
        });
}
