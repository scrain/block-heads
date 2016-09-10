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

    function AgentOffer(string name, string description, string offerType, uint maxPayout, string term, string frequency, uint instatedDate) {
        pendingAmount = 0;
        amount = 0;

        name = name;
        description = description;
        offerType = offerType;
        maxPayout = maxPayout;
        term = term;
        frequency = frequency;
        instatedDate = instatedDate;
        owner = msg.sender;

    }

	function setOwner(address owner) {
		owner = owner;
	}
	function getOwner() constant returns (address retVal) {
		return owner;
	}
	function setName(string name) {
        name = name;
    }
    function getName() constant returns (string name) {
        return name;
    }
    function setDescription(string description) {
        description = description;
    }
    function getDescription() constant returns (string description) {
        return description;
    }
    function setOfferType(string offerType) {
        offerType = offerType;
    }
    function getOfferType() constant returns (string offerType) {
        return offerType;
    }
    function setPendingAmount(uint amount) {
        pendingAmount = amount;
    }
    function getPendingAmount() constant returns (uint pendingAmount) {
        return pendingAmount;
    }
    function setAmount(uint amount) {
        amount = amount;
    }
    function getAmount() constant returns (uint amount) {
        return amount;
    }
    function setMaxPayout(uint maxPayout) {
        maxPayout = maxPayout;
    }
    function getMaxPayout() constant returns (uint maxPayout) {
        return maxPayout;
    }
    function setTerm(string term) {
        term = term;
    }
    function getTerm() constant returns (string term) {
        return term;
    }
    function setFrequency(string frequency) {
        frequency = frequency;
    }
    function getFrequency() constant returns (string frequency) {
        return frequency;
    }
    function setInstatedDate(uint instatedDate) {
        instatedDate = instatedDate;
    }
    function getInstatedDate() constant returns (uint instatedDate) {
        return instatedDate;
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
