//= wrapped
//= require /angular/angular
//= require_tree /bootflat
//= require /blockheads/core/blockheads.core
//= require /blockheads/index/blockheads.index
//= require /blockheads/agent/blockheads.agent
//= require /blockheads/state/blockheads.state
//= require /blockheads/contract/blockheads.contract
//= require /blockheads/incentive/blockheads.incentive
//= require /blockheads/transaction/blockheads.transaction
//= require /blockheads/insuranceApp/blockheads.insuranceApp

angular.module("blockheads", [
    "blockheads.core",
    "blockheads.index",
    "blockheads.agent",
    "blockheads.state",
    "blockheads.contract",
    "blockheads.incentive",
    "blockheads.transaction",
    "blockheads.insuranceApp"
]);

