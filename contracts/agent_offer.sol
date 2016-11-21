contract AgentOffer {
    address owner;
	string name;
    string description;
    string offerType;
    uint pendingAmount;
    uint amount;
    uint maxPayout;
    string term;
    string frequency;
    uint instatedDate;

    event CurrentState(address ownerVar, string nameVar, string descriptionVar, string offerTypeVar, uint pendingAmountVar, uint amountVar, uint maxPayoutVar, string termVar, string frequencyVar, uint instatedDate);

    function retrieveState() {
        CurrentState(owner, name, description, offerType, pendingAmount, amount, maxPayout, term, frequency, instatedDate);
    }

    function AgentOffer(string nameVar, string descriptionVar, string offerTypeVar, uint pendingAmountVar, uint amountVar, uint maxPayoutVar, string termVar, string frequencyVar, uint instatedDateVar) {
        pendingAmount = pendingAmountVar;
        amount = amountVar;

        name = nameVar;
        description = descriptionVar;
        offerType = offerTypeVar;
        maxPayout = maxPayoutVar;
        term = termVar;
        frequency = frequencyVar;
        instatedDate = instatedDateVar;
        owner = msg.senderVar;

    }

	function setOwner(address ownerVar) {
		owner = ownerVar;
	}
	function getOwner() constant returns (address retVal) {
		retVal = owner;
	}
	function setName(string nameVar) {
        name = nameVar;
    }
    function getName() constant returns (string retVal) {
        retVal = name;
    }
    function setDescription(string descriptionVar) {
        description = descriptionVar;
    }
    function getDescription() constant returns (string retVal) {
        retVal = description;
    }
    function setOfferType(string offerTypeVar) {
        offerType = offerTypeVar;
    }
    function getOfferType() constant returns (string retVal) {
        retVal = offerType;
    }
    function setPendingAmount(uint amountVar) {
        pendingAmount = amount;
    }
    function getPendingAmount() constant returns (uint retVal) {
        pendingAmountRtrn =  pendingAmount;
    }
    function setAmount(uint amountVar) {
        amount = amountVar;
    }
    function getAmount() constant returns (uint amountVal) {
        amountVal = amountVal;
    }
    function setMaxPayout(uint maxPayoutVar) {
        maxPayout = maxPayoutVar;
    }
    function getMaxPayout() constant returns (uint retVal) {
        retVal = maxPayout;
    }
    function setTerm(string termVar) {
        term = termVar;
    }
    function getTerm() constant returns (string retVal) {
        retVal = term;
    }
    function setFrequency(string frequencyVar) {
        frequency = frequencyVar;
    }
    function getFrequency() constant returns (string retVal) {
        retVal = frequency;
    }
    function setInstatedDate(uint instatedDateVar) {
        instatedDate = instatedDateVar;
    }
    function getInstatedDate() constant returns (uint retVal) {
        retVal = instatedDate;
    }

    function movePendingToInforcedAmount(uint amount) {
        removeFromPendingAmount(amount);
        addToInforceAmount(amount);
    }
    function removeFromPendingAmount(uint amount) {
        pendingAmount -= amount;
    }
    function removeFromInforceAmount(uint amount) {
        amount -= amount;
    }
    function addToPendingAmount(uint amount) {
        pendingAmount += amount;
    }
    function addToInforceAmount(uint amount) {
        amount += amount;
    }
}
