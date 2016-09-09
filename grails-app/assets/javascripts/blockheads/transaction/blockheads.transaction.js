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

angular.module("blockheads.transaction", ["ui.router", "ngResource", "blockheads.core"]).config(config);

function config($stateProvider) {
    $stateProvider
        .state('transaction', {
            url: "/transaction",
            abstract: true,
            template: "<div ui-view></div>"
        })
        .state('transaction.list', {
            url: "",
            templateUrl: "/blockheads/transaction/list.html",
            controller: "TransactionListController as vm"
        })
        .state('transaction.create', {
            url: "/create",
            templateUrl: "/blockheads/transaction/create.html",
            controller: "TransactionCreateController as vm"
        })
        .state('transaction.edit', {
            url: "/edit/:id",
            templateUrl: "/blockheads/transaction/edit.html",
            controller: "TransactionEditController as vm"
        })
        .state('transaction.show', {
            url: "/show/:id",
            templateUrl: "/blockheads/transaction/show.html",
            controller: "TransactionShowController as vm"
        });
}
