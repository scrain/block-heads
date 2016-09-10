;(function () {
    'use strict';
    angular.module('blockheads.contract').factory('contractService',
        function ($resource, $window, $q, Agent, Transaction) {
            var agentOfferSolidity="contract AgentOffer {    address owner;	string name;    string description;    string offerType;    uint amount;    uint maxPayout;    string term;    string frequency;    function AgentOffer(string name, string description, string offerType, uint amount, uint maxPayout, string term, string frequency) {        name = name;        description = description;        offerType = offerType;        amount = amount;        maxPayout = maxPayout;        term = term;        frequency = frequency;        owner = msg.sender;    }	function setOwner(address owner) {		owner = owner;	}	function getOwner() constant returns (address retVal) {		return owner;	}	function setName(string name) {        name = name;    }    function getName() constant returns (string name) {        return name;    }    function setDescription(string description) {        description = description;    }    function getDescription() constant returns (string description) {        return description;    }    function setOfferType(string offerType) {        offerType = offerType;    }    function getOfferType() constant returns (string offerType) {        return offerType;    }    function setAmount(uint amount) {        amount = amount;    }    function getAmount() constant returns (uint amount) {        return amount;    }    function setMaxPayout(uint maxPayout) {        maxPayout = maxPayout;    }    function getMaxPayout() constant returns (uint maxPayout) {        return maxPayout;    }    function setTerm(string term) {        term = term;    }    function getTerm() constant returns (string term) {        return term;    }    function setFrequency(string frequency) {        frequency = frequency;    }    function getFrequency() constant returns (string frequency) {        return frequency;    }}";
            var cacheOfCompiledContracts = {agentOfferDetails: [
                [{"constant":true,"inputs":[],"name":"getFrequency","outputs":[{"name":"frequency","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"term","type":"string"}],"name":"setTerm","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getTerm","outputs":[{"name":"term","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"owner","type":"address"}],"name":"setOwner","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getName","outputs":[{"name":"name","type":"string"}],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getDescription","outputs":[{"name":"description","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"setAmount","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getMaxPayout","outputs":[{"name":"maxPayout","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"movePendingToInforcedAmount","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"maxPayout","type":"uint256"}],"name":"setMaxPayout","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"removeFromPendingAmount","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"addToInforceAmount","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"addToPendingAmount","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getOwner","outputs":[{"name":"retVal","type":"address"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"removeFromInforceAmount","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"description","type":"string"}],"name":"setDescription","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"frequency","type":"string"}],"name":"setFrequency","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getOfferType","outputs":[{"name":"offerType","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"name","type":"string"}],"name":"setName","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getAmount","outputs":[{"name":"amount","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"offerType","type":"string"}],"name":"setOfferType","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getPendingAmount","outputs":[{"name":"pendingAmount","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"setPendingAmount","outputs":[],"payable":false,"type":"function"},{"inputs":[{"name":"name","type":"string"},{"name":"description","type":"string"},{"name":"offerType","type":"string"},{"name":"maxPayout","type":"uint256"},{"name":"term","type":"string"},{"name":"frequency","type":"string"}],"type":"constructor"}],
                '606060405260405161099a38038061099a833981016040528080518201919060200180518201919060200180518201919060200180519060200190919080518201919060200180518201919060200150505b6000600460005081905550600060056000508190555085955085508494508450839350835082925082508191508150809050805033600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908302179055505b5050505050506108d5806100c56000396000f36060604052361561012f576000357c0100000000000000000000000000000000000000000000000000000000900480630a42f86f146101345780630c76f69d146101b4578063124b65b41461020f57806313af40351461028f57806317d7de7c146102ac5780631a0925411461032c578063271f88b4146103ac5780632d9a37d3146103c95780634cd57a45146103f157806356b4997f1461040e57806361186cba1461042b5780636699c97c14610448578063841094c214610465578063893d20e8146104825780638a4c2a88146104c057806390c3f38f146104dd5780639c16b8fd14610538578063af5372e614610593578063c47f002714610613578063d321fe291461066e578063d4f62f5614610696578063e81ab3ff146106f1578063ef477da4146107195761012f565b610002565b34610002576101466004805050610736565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156101a65780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b346100025761020d6004808035906020019082018035906020019191908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050909091905050610755565b005b3461000257610221600480505061075e565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156102815780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34610002576102aa600480803590602001909190505061077d565b005b34610002576102be6004805050610786565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f16801561031e5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b346100025761033e60048050506107a5565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f16801561039e5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34610002576103c760048080359060200190919050506107c4565b005b34610002576103db60048050506107cd565b6040518082815260200191505060405180910390f35b346100025761040c60048080359060200190919050506107da565b005b346100025761042960048080359060200190919050506107f0565b005b346100025761044660048080359060200190919050506107f9565b005b3461000257610463600480803590602001909190505061080f565b005b3461000257610480600480803590602001909190505061081a565b005b34610002576104946004805050610830565b604051808273ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34610002576104db600480803590602001909190505061085f565b005b34610002576105366004808035906020019082018035906020019191908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505090909190505061086a565b005b34610002576105916004808035906020019082018035906020019191908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050909091905050610873565b005b34610002576105a5600480505061087c565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156106055780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b346100025761066c6004808035906020019082018035906020019191908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505090909190505061089b565b005b346100025761068060048050506108a4565b6040518082815260200191505060405180910390f35b34610002576106ef6004808035906020019082018035906020019191908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509090919050506108b1565b005b346100025761070360048050506108ba565b6040518082815260200191505060405180910390f35b346100025761073460048080359060200190919050506108c7565b005b6020604051908101604052806000815260200150809050610752565b90565b80905080505b50565b602060405190810160405280600081526020015080905061077a565b90565b80905080505b50565b60206040519081016040528060008152602001508090506107a2565b90565b60206040519081016040528060008152602001508090506107c1565b90565b80905080505b50565b60008090506107d7565b90565b6107e3816107f9565b6107ec8161080f565b5b50565b80905080505b50565b8060046000828282505403925050819055505b50565b808101905080505b50565b8060046000828282505401925050819055505b50565b6000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905061085c565b90565b808103905080505b50565b80905080505b50565b80905080505b50565b6020604051908101604052806000815260200150809050610898565b90565b80905080505b50565b60008090506108ae565b90565b80905080505b50565b60008090506108c4565b90565b806004600050819055505b5056'
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
                    var temp;
                    if (insuranceApp.status === 'pending') {
                        agentOfferContractInstance.addToPendingAmount(insuranceApp.faceAmount);
                        transactionStatus = 'pending'; // add to pending
                        temp = agentOfferContractInstance.getPendingAmount();
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

                    agent.transactions.push(transaction);

                    agent.$update({}, function() {
                        console.log('saved transaction to db');
                        //$state.go('agent.edit', {id: vm.agent.id});
                    }, function(response) {
                        var data = response.data;
                        console.log('error saving agent with new Transaction obj to db');
                        if (data.hasOwnProperty('message')) {
                            console.log('message = '+ data);
                        } else {
                            data._embedded.errors.forEach(function(error) {
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
