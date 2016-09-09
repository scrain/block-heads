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

angular.module("blockheads.incentive", ["ui.router", "ngResource", "blockheads.core"]).config(config);

function config($stateProvider) {
    $stateProvider
        .state('incentive', {
            url: "/incentive",
            abstract: true,
            template: "<div ui-view></div>"
        })
        .state('incentive.list', {
            url: "",
            templateUrl: "/blockheads/incentive/list.html",
            controller: "IncentiveListController as vm"
        })
        .state('incentive.create', {
            url: "/create",
            templateUrl: "/blockheads/incentive/create.html",
            controller: "IncentiveCreateController as vm"
        })
        .state('incentive.edit', {
            url: "/edit/:id",
            templateUrl: "/blockheads/incentive/edit.html",
            controller: "IncentiveEditController as vm"
        })
        .state('incentive.show', {
            url: "/show/:id",
            templateUrl: "/blockheads/incentive/show.html",
            controller: "IncentiveShowController as vm"
        });
}
