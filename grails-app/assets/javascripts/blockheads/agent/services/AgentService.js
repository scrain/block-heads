;(function () {
    'use strict';
    angular.module('blockheads.agent').factory('contractService',
        function ($resource, $window, $q) {
            var agent // save logged in
            function setcreateAgentOffer(contract, callback){
                var agentOfferContract = web3.eth.contract(cacheOfCompiledContracts.agentOfferDetails[0]);

                var createTransaction = agentOfferContract.new(contract.name, contract.description, contract.type,
                    contract.amount, contract.maxPayout, contract.term, contract.frequency, {
                    data: cacheOfCompiledContracts.agentOfferDetails[1],
                    gas: 3000000,
                    from: web3.eth.accounts[0].address}, callback);
                        //'0x2465d5dc46ed5e7cf42ff430579a9dc6fa74aa85'}, callback);

            }

            function updateAgentOffer(insuranceApp) {
                if (insuranceApp.id) { // update existing insurance app

                } else { // new insurance app

                }

            }

            function getAgentOffer(address) {

            }

            var service = {
                createAgentOffer: createAgentOffer,
                updateAgentOffer: updateAgentOffer,
                getAgentOffer: getAgentOffer
            };

            return service;
        });
})();
