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

angular.module("blockheads.insuranceApp", ["ui.router", "ngResource", "blockheads.core"]).config(config);

function config($stateProvider) {
    $stateProvider
        .state('insuranceApp', {
            url: "/insuranceApp",
            abstract: true,
            template: "<div ui-view></div>"
        })
        .state('insuranceApp.list', {
            url: "",
            templateUrl: "/blockheads/insuranceApp/list.html",
            controller: "InsuranceAppListController as vm"
        })
        .state('insuranceApp.create', {
            url: "/create",
            templateUrl: "/blockheads/insuranceApp/create.html",
            controller: "InsuranceAppCreateController as vm"
        })
        .state('insuranceApp.edit', {
            url: "/edit/:id",
            templateUrl: "/blockheads/insuranceApp/edit.html",
            controller: "InsuranceAppEditController as vm"
        })
        .state('insuranceApp.show', {
            url: "/show/:id",
            templateUrl: "/blockheads/insuranceApp/show.html",
            controller: "InsuranceAppShowController as vm"
        });
}
