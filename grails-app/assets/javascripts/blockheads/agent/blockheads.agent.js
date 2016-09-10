//= wrapped
//= require /angular/angular 
//= require /angular/angular-ui-router
//= require /angular/angular-resource
//= require /blockheads/core/blockheads.core
//= require /blockheads/state/blockheads.state
//= require /blockheads/contract/blockheads.contract
//= require /blockheads/incentive/blockheads.incentive
//= require /blockheads/transaction/blockheads.transaction
//= require_self
//= require_tree services
//= require_tree controllers
//= require_tree directives
//= require_tree domain
//= require_tree templates

angular.module("blockheads.agent", [
    "ui.router",
    "ngResource",
    "blockheads.core",
    "blockheads.state",
    "blockheads.contract",
    "blockheads.incentive",
    "blockheads.transaction"
]).config(config);

function config($stateProvider) {
    $stateProvider
        .state('agent', {
            url: "/agent",
            abstract: true,
            template: "<div ui-view></div>"
        })
        .state('agent.list', {
            url: "",
            templateUrl: "/blockheads/agent/list.html",
            controller: "AgentListController as vm"
        })
        .state('agent.create', {
            url: "/create",
            templateUrl: "/blockheads/agent/create.html",         // create account (step 1)
            controller: "AgentCreateController as vm"
        })
        .state('agent.edit', {
            url: "/edit/:id",
            templateUrl: "/blockheads/agent/edit.html",           // enter personal info (step 2)
            controller: "AgentEditController as vm"
        })
        .state('agent.select-contract', {
            url: "/selectContract/:id",
            templateUrl: "/blockheads/agent/select-contract.html", // select contract (step 3)
            controller: "AgentEditController as vm"
        })
        .state('agent.show', {
            url: "/show/:id",
            templateUrl: "/blockheads/agent/show.html",
            controller: "AgentShowController as vm"
        });
}
