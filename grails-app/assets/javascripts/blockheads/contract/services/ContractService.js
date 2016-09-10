;(function () {
    'use strict';
    angular.module('blockheads.contract').factory('contractService',
        function ($resource, $window, $q, Agent, Transaction) {

            var cacheOfCompiledContracts = {agentOfferDetails: [
                [{"constant":true,"inputs":[],"name":"getFrequency","outputs":[{"name":"frequency","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"term","type":"string"}],"name":"setTerm","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[],"name":"retrieveState","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getTerm","outputs":[{"name":"term","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"owner","type":"address"}],"name":"setOwner","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getName","outputs":[{"name":"name","type":"string"}],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getDescription","outputs":[{"name":"description","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"setAmount","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"instatedDate","type":"uint256"}],"name":"setInstatedDate","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getMaxPayout","outputs":[{"name":"maxPayout","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"movePendingToInforcedAmount","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getInstatedDate","outputs":[{"name":"instatedDate","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"maxPayout","type":"uint256"}],"name":"setMaxPayout","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"removeFromPendingAmount","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"addToInforceAmount","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"addToPendingAmount","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getOwner","outputs":[{"name":"retVal","type":"address"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"removeFromInforceAmount","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"description","type":"string"}],"name":"setDescription","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"frequency","type":"string"}],"name":"setFrequency","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getOfferType","outputs":[{"name":"offerType","type":"string"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"name","type":"string"}],"name":"setName","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getAmount","outputs":[{"name":"amount","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"offerType","type":"string"}],"name":"setOfferType","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getPendingAmount","outputs":[{"name":"pendingAmount","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"amount","type":"uint256"}],"name":"setPendingAmount","outputs":[],"payable":false,"type":"function"},{"inputs":[{"name":"name","type":"string"},{"name":"description","type":"string"},{"name":"offerType","type":"string"},{"name":"pendingAmount","type":"uint256"},{"name":"amount","type":"uint256"},{"name":"maxPayout","type":"uint256"},{"name":"term","type":"string"},{"name":"frequency","type":"string"},{"name":"instatedDate","type":"uint256"}],"type":"constructor"},{"anonymous":false,"inputs":[{"indexed":false,"name":"owner","type":"address"},{"indexed":false,"name":"name","type":"string"},{"indexed":false,"name":"description","type":"string"},{"indexed":false,"name":"offerType","type":"string"},{"indexed":false,"name":"pendingAmount","type":"uint256"},{"indexed":false,"name":"amount","type":"uint256"},{"indexed":false,"name":"maxPayout","type":"uint256"},{"indexed":false,"name":"term","type":"string"},{"indexed":false,"name":"frequency","type":"string"},{"indexed":false,"name":"instatedDate","type":"uint256"}],"name":"CurrentState","type":"event"}],
                '6060604052604051610dad380380610dad833981016040528080518201919060200180518201919060200180518201919060200180519060200190919080519060200190919080519060200190919080518201919060200180518201919060200180519060200190919050505b85955085508494508450889850885087975087508696508650839350835082925082508191508150809050805033600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908302179055505b505050505050505050610cd1806100dc6000396000f360606040523615610150576000357c0100000000000000000000000000000000000000000000000000000000900480630a42f86f146101555780630c76f69d146101d55780631187944914610230578063124b65b41461024457806313af4035146102c457806317d7de7c146102e15780631a09254114610361578063271f88b4146103e157806329ea920d146103fe5780632d9a37d31461041b5780634cd57a45146104435780634de1e0421461046057806356b4997f1461048857806361186cba146104a55780636699c97c146104c2578063841094c2146104df578063893d20e8146104fc5780638a4c2a881461053a57806390c3f38f146105575780639c16b8fd146105b2578063af5372e61461060d578063c47f00271461068d578063d321fe29146106e8578063d4f62f5614610710578063e81ab3ff1461076b578063ef477da41461079357610150565b610002565b346100025761016760048050506107b0565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156101c75780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b346100025761022e6004808035906020019082018035906020019191908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509090919050506107cf565b005b346100025761024260048050506107d8565b005b34610002576102566004805050610b44565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156102b65780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34610002576102df6004808035906020019091905050610b63565b005b34610002576102f36004805050610b6c565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156103535780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34610002576103736004805050610b8b565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156103d35780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34610002576103fc6004808035906020019091905050610baa565b005b34610002576104196004808035906020019091905050610bb3565b005b346100025761042d6004805050610bbc565b6040518082815260200191505060405180910390f35b346100025761045e6004808035906020019091905050610bc9565b005b34610002576104726004805050610bdf565b6040518082815260200191505060405180910390f35b34610002576104a36004808035906020019091905050610bec565b005b34610002576104c06004808035906020019091905050610bf5565b005b34610002576104dd6004808035906020019091905050610c0b565b005b34610002576104fa6004808035906020019091905050610c16565b005b346100025761050e6004805050610c2c565b604051808273ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34610002576105556004808035906020019091905050610c5b565b005b34610002576105b06004808035906020019082018035906020019191908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050909091905050610c66565b005b346100025761060b6004808035906020019082018035906020019191908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050909091905050610c6f565b005b346100025761061f6004805050610c78565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f16801561067f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34610002576106e66004808035906020019082018035906020019191908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050909091905050610c97565b005b34610002576106fa6004805050610ca0565b6040518082815260200191505060405180910390f35b34610002576107696004808035906020019082018035906020019191908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050909091905050610cad565b005b346100025761077d6004805050610cb6565b6040518082815260200191505060405180910390f35b34610002576107ae6004808035906020019091905050610cc3565b005b60206040519081016040528060008152602001508090506107cc565b90565b80905080505b50565b7fa10e2a58977a8a0ce4b734250775ca415614eca9b1f87cba6a8426265c051e0e600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660016000506002600050600360005060046000505460056000505460066000505460076000506008600050600960005054604051808b73ffffffffffffffffffffffffffffffffffffffff1681526020018060200180602001806020018a8152602001898152602001888152602001806020018060200187815260200186810386528f81815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561091a5780601f106108ef5761010080835404028352916020019161091a565b820191906000526020600020905b8154815290600101906020018083116108fd57829003601f168201915b505086810385528e81815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561099d5780601f106109725761010080835404028352916020019161099d565b820191906000526020600020905b81548152906001019060200180831161098057829003601f168201915b505086810384528d818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610a205780601f106109f557610100808354040283529160200191610a20565b820191906000526020600020905b815481529060010190602001808311610a0357829003601f168201915b5050868103835289818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610aa35780601f10610a7857610100808354040283529160200191610aa3565b820191906000526020600020905b815481529060010190602001808311610a8657829003601f168201915b5050868103825288818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610b265780601f10610afb57610100808354040283529160200191610b26565b820191906000526020600020905b815481529060010190602001808311610b0957829003601f168201915b50509f5050505050505050505050505050505060405180910390a15b565b6020604051908101604052806000815260200150809050610b60565b90565b80905080505b50565b6020604051908101604052806000815260200150809050610b88565b90565b6020604051908101604052806000815260200150809050610ba7565b90565b80905080505b50565b80905080505b50565b6000809050610bc6565b90565b610bd281610bf5565b610bdb81610c0b565b5b50565b6000809050610be9565b90565b80905080505b50565b8060046000828282505403925050819055505b50565b808101905080505b50565b8060046000828282505401925050819055505b50565b6000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050610c58565b90565b808103905080505b50565b80905080505b50565b80905080505b50565b6020604051908101604052806000815260200150809050610c94565b90565b80905080505b50565b6000809050610caa565b90565b80905080505b50565b6000809050610cc0565b90565b806004600050819055505b5056'
            ]};

            function createAgentOffer(contract, callback){
                var agentOfferContract = web3.eth.contract(cacheOfCompiledContracts.agentOfferDetails[0]);
                var longtimestamp = new Date().getTime();
                var createTransaction = agentOfferContract.new(contract.name, contract.description, contract.type,
                    0, 0, contract.maxPayout, contract.term, contract.frequency, longtimestamp, {
                        data: cacheOfCompiledContracts.agentOfferDetails[1],
                        gas: 3000000,
                        from: web3.eth.accounts[0].address}, callback);

            }

            function updateAgentOffer(insuranceApp, callback) { // handles new and updated insuranceApps
                Agent.list({max: 1000, offset: 0}, function(agentList) {
                    var agent = agentList.find(function(agent) {
                        return agent.agentId = insuranceApp.agentId;
                    });
                    var previousContractTransaction = agent.transactions.reverse().find(function(transaction) {
                        return transaction.contractNumber === insuranceApp.number;
                    });

                    //var agentOfferContractInstance = getAgentOffer(agent.contractAddress);
                    var agentOfferContract = web3.eth.contract(cacheOfCompiledContracts.agentOfferDetails[0]);
                    var agentOfferContractInstance = agentOfferContract.at(agent.contractAddress);

                    var transactionStatus;
                    if (insuranceApp.status === 'pending') {
                        agentOfferContractInstance.addToPendingAmount(insuranceApp.faceAmount);
                        transactionStatus = 'pending'; // add to pending
                        agentOfferContractInstance.getPendingAmount(function(err, data) { console.log(data);});

                        var event = agentOfferContractInstance.retrieveState(function(error, result){
                            if (!error) {
                                console.log(result);
                            }
                        });

                    } else if (insuranceApp.status === 'issued'){
                        agentOfferContractInstance.movePendingToInforcedAmount(insuranceApp.faceAmount, function(err, data) { console.log(data);});
                        transactionStatus = 'complete'; // subtract from pending and move to inforced
                    } else if (insuranceApp.status === 'declined'){
                        if (previousContractTransaction.status === 'pending') {
                            agentOfferContractInstance.removeFromPendingAmount.sendTransaction(insuranceApp.faceAmount);
                        } else { // remove from inforced amount
                            agentOfferContractInstance.removeFromInforceAmount.sendTransaction(insuranceApp.faceAmount);
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
                var agentOfferContract = web3.eth.contract(cacheOfCompiledContracts.agentOfferDetails[0]);
                var agentOfferContractInstance = agentOfferContract.at(address);
                return agentOfferContractInstance;
            }

            var service = {
                createAgentOffer: createAgentOffer,
                updateAgentOffer: updateAgentOffer,
                getAgentOffer: getAgentOffer
            };

            return service;
        });
})();
