//= wrapped
//= require /bootflat/icheck.min
//= require /bootflat/jquery.fs.selecter.min
//= require /bootflat/jquery.fs.stepper.min
//= require /angular/angular
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

angular.module('blockheads').run(
    function(Contract, Agent, contractService) {
        function handle(id) {

            function getBlockChainCallback(agent) {
                return function(err, myContract){
                    if(!err) {
                        if(myContract.address) {
                            console.log('address ='+ myContract.address) // the contract address
                            agent.contractAddress = myContract.address;
                            agent.$update(function() {
                                console.log('agent updated with contract. email='+ agent.email +' contractAddress='+ agent.contractAddress);
                            }, function() {
                                console.log('error saving agent on bootstrap');
                            });
                        } else {
                            console.log(myContract.transactionHash) // The hash of the transaction, which deploys the contract
                        }
                    } else {
                        console.log(err);
                    }
                };
            }

            Agent.get({id: id}, function(agentData) {
                var agent = new Agent(agentData);
                if (agent.contract && !agent.contractAddress) {
                    contractService.createAgentOffer(agent.contract, getBlockChainCallback(agent));
                }
            }, function() {
                console.log('error initializing Contract during js bootstrap process.')
            });
        }

        handle(1);
        handle(2);
        handle(3);

    }
);

