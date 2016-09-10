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
            templateUrl: "/blockheads/agent/create.html",
            controller: "AgentCreateController as vm"
        })
        .state('agent.login', {
            url: "/login",
            templateUrl: "/blockheads/agent/login.html",
            controller: "AgentLoginController as vm"
        })
        .state('agent.edit', {
            url: "/edit/:id",
            templateUrl: "/blockheads/agent/edit.html",
            controller: "AgentEditController as vm"
        })
        .state('agent.show', {
            url: "/show/:id",
            templateUrl: "/blockheads/agent/show.html",
            controller: "AgentShowController as vm"
        });
}
