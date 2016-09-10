;(function () {
    'use strict';
    angular.module('blockheads.contract').factory('contractService',
        function ($resource, $window, $q, Agent, Transaction) {
            var agentOfferSolidity="contract AgentOffer {    address owner;	string name;    string description;    string offerType;    uint amount;    uint maxPayout;    string term;    string frequency;    function AgentOffer(string name, string description, string offerType, uint amount, uint maxPayout, string term, string frequency) {        name = name;        description = description;        offerType = offerType;        amount = amount;        maxPayout = maxPayout;        term = term;        frequency = frequency;        owner = msg.sender;    }	function setOwner(address owner) {		owner = owner;	}	function getOwner() constant returns (address retVal) {		return owner;	}	function setName(string name) {        name = name;    }    function getName() constant returns (string name) {        return name;    }    function setDescription(string description) {        description = description;    }    function getDescription() constant returns (string description) {        return description;    }    function setOfferType(string offerType) {        offerType = offerType;    }    function getOfferType() constant returns (string offerType) {        return offerType;    }    function setAmount(uint amount) {        amount = amount;    }    function getAmount() constant returns (uint amount) {        return amount;    }    function setMaxPayout(uint maxPayout) {        maxPayout = maxPayout;    }    function getMaxPayout() constant returns (uint maxPayout) {        return maxPayout;    }    function setTerm(string term) {        term = term;    }    function getTerm() constant returns (string term) {        return term;    }    function setFrequency(string frequency) {        frequency = frequency;    }    function getFrequency() constant returns (string frequency) {        return frequency;    }}";
            var cacheOfCompiledContracts = {agentOfferDetails: [
                [{"constant":true,"inputs":[],"name":"getFrequency","outputs":[{"name":"frequency","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"term","type":"string"}],"name":"setTerm","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getTerm","outputs":[{"name":"term","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"owner","type":"address"}],"name":"setOwner","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getName","outputs":[{"name":"name","type":"string"}],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getDescription","outputs":[{"name":"description","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"setAmount","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getMaxPayout","outputs":[{"name":"maxPayout","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"movePendingToInforcedAmount","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"maxPayout","type":"uint256"}],"name":"setMaxPayout","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"removeFromPendingAmount","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getOwner","outputs":[{"name":"retVal","type":"address"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"removeFromInforceAmount","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"description","type":"string"}],"name":"setDescription","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"frequency","type":"string"}],"name":"setFrequency","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getOfferType","outputs":[{"name":"offerType","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"name","type":"string"}],"name":"setName","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getAmount","outputs":[{"name":"amount","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"offerType","type":"string"}],"name":"setOfferType","outputs":[],"payable":false,"type":"function"},{"inputs":[{"name":"name","type":"string"},{"name":"description","type":"string"},{"name":"offerType","type":"string"},{"name":"maxPayout","type":"uint256"},{"name":"term","type":"string"},{"name":"frequency","type":"string"}],"type":"constructor"}],
                '60606040526040516108b13803806108b1833981016040528080518201919060200180518201919060200180518201919060200180519060200190919080518201919060200180518201919060200150505b6000600460005081905550600060056000508190555085955085508494508450839350835082925082508191508150809050805033600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908302179055505b5050505050506107ec806100c56000396000f360606040523615610103576000357c0100000000000000000000000000000000000000000000000000000000900480630a42f86f146101085780630c76f69d14610188578063124b65b4146101e357806313af40351461026357806317d7de7c146102805780631a09254114610300578063271f88b4146103805780632d9a37d31461039d5780634cd57a45146103c557806356b4997f146103e257806361186cba146103ff578063893d20e81461041c5780638a4c2a881461045a57806390c3f38f146104775780639c16b8fd146104d2578063af5372e61461052d578063c47f0027146105ad578063d321fe2914610608578063d4f62f561461063057610103565b610002565b346100025761011a600480505061068b565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f16801561017a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34610002576101e16004808035906020019082018035906020019191908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509090919050506106aa565b005b34610002576101f560048050506106b3565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156102555780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b346100025761027e60048080359060200190919050506106d2565b005b346100025761029260048050506106db565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156102f25780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b346100025761031260048050506106fa565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156103725780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b346100025761039b6004808035906020019091905050610719565b005b34610002576103af6004805050610722565b6040518082815260200191505060405180910390f35b34610002576103e0600480803590602001909190505061072f565b005b34610002576103fd6004808035906020019091905050610743565b005b346100025761041a600480803590602001909190505061074c565b005b346100025761042e6004805050610762565b604051808273ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34610002576104756004808035906020019091905050610791565b005b34610002576104d06004808035906020019082018035906020019191908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505090909190505061079c565b005b346100025761052b6004808035906020019082018035906020019191908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509090919050506107a5565b005b346100025761053f60048050506107ae565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f16801561059f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34610002576106066004808035906020019082018035906020019191908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509090919050506107cd565b005b346100025761061a60048050506107d6565b6040518082815260200191505060405180910390f35b34610002576106896004808035906020019082018035906020019191908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509090919050506107e3565b005b60206040519081016040528060008152602001508090506106a7565b90565b80905080505b50565b60206040519081016040528060008152602001508090506106cf565b90565b80905080505b50565b60206040519081016040528060008152602001508090506106f7565b90565b6020604051908101604052806000815260200150809050610716565b90565b80905080505b50565b600080905061072c565b90565b6107388161074c565b808101905080505b50565b80905080505b50565b8060046000828282505403925050819055505b50565b6000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905061078e565b90565b808103905080505b50565b80905080505b50565b80905080505b50565b60206040519081016040528060008152602001508090506107ca565b90565b80905080505b50565b60008090506107e0565b90565b80905080505b5056'
            ]};

            function createAgentOffer(contract, callback){
                var agentOfferContract = web3.eth.contract(cacheOfCompiledContracts.agentOfferDetails[0]);

                var createTransaction = agentOfferContract.new(contract.name, contract.description, contract.type,
                    contract.amount, contract.maxPayout, contract.term, contract.frequency, {
                    data: cacheOfCompiledContracts.agentOfferDetails[1],
                    gas: 4700000,
                    from: web3.eth.accounts[0].address}, callback);
                        //'0x2465d5dc46ed5e7cf42ff430579a9dc6fa74aa85'}, callback);

            }

            function updateAgentOffer(insuranceApp, callback) { // handles new and updated insuranceApps

                Agent.get({id: insuranceApp.agentId}, function(data) {
                    var agent = new Agent(data);

                    var previousContractTransaction = agent.transactions.reverse().find(function(transaction) {
                        return transaction.contractNumber === insuranceApp.number;
                    });

                    var agentOfferContract = web3.eth.contract(cacheOfCompiledContracts.agentOfferDetails[0]);
                    var agentOfferContractInstance = agentOfferContract.at(agent.contractAddress);

                    var transactionStatus;
                    previousContractTransaction
                    if (insuranceApp.status === 'pending') {
                        transactionStatus = 'pending'; // add to pending
                    } else if (insuranceApp.status === 'issued'){
                        agentOfferContractInstance.movePendingToInforcedAmount(insuranceApp.faceAmount);
                        transactionStatus = 'complete'; // subtract from pending and move to inforced
                    } else if (insuranceApp.status === 'declined'){
                        if (previousContractTransaction.status === 'pending') {
                            agentOfferContractInstance.removeFromPendingAmount(insuranceApp.faceAmount);
                        } else { // remove from inforced amount
                            agentOfferContractInstance.removeFromInforceAmount(insuranceApp.faceAmount);
                        }
                        transactionStatus = 'cancelled'; // drives movement of $$ from pendingAmount to Amount
                    }

                    var transaction = new Transaction({contractNumber: insuranceApp.number,
                        status:transactionStatus, faceAmount:insuranceApp.faceAmount,
                        premium:insuranceApp.premium});

                    transaction.$save({}, function() {
                        console.log('saved transaction to db');
                        //$state.go('agent.edit', {id: vm.agent.id});
                    }, function(response) {
                        console('error data when saving Transaction to db');
                        if (data.hasOwnProperty('message')) {
                            console.log('message = '+ response.data);
                        } else {
                            _.forEach(response._embedded.errors, function(error) {
                                console.log(error);
                            });
                        }
                    });

                }, function(err) {
                    console.log('couldn\'t retrieve agent for agentId='+ insuranceApp.agentId);
                    console.log('err='+ err);
                });
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
