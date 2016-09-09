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

angular.module("blockheads.contract", ["ui.router", "ngResource", "blockheads.core"]).config(config);

function config($stateProvider) {
    $stateProvider
        .state('contract', {
            url: "/contract",
            abstract: true,
            template: "<div ui-view></div>"
        })
        .state('contract.list', {
            url: "",
            templateUrl: "/blockheads/contract/list.html",
            controller: "ContractListController as vm"
        })
        .state('contract.create', {
            url: "/create",
            templateUrl: "/blockheads/contract/create.html",
            controller: "ContractCreateController as vm"
        })
        .state('contract.edit', {
            url: "/edit/:id",
            templateUrl: "/blockheads/contract/edit.html",
            controller: "ContractEditController as vm"
        })
        .state('contract.show', {
            url: "/show/:id",
            templateUrl: "/blockheads/contract/show.html",
            controller: "ContractShowController as vm"
        });
}
