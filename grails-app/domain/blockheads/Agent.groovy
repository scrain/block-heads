package blockheads


import grails.rest.*
import groovy.transform.Sortable

@Sortable(includes=['lastName', 'firstName'])
@Resource(readOnly = false, formats = ['json', 'xml'])
class Agent {
    String username
    String password
    String firstName
    String lastName
    String email

    String trainingStatus

    String governmentId
    Date birthday

    String address1
    String address2
    String city
    State state

    String zip

    String agentId
    SortedSet<State> licenseStates

    Contract contract
    SortedSet<Incentive> incentives

    String contractAddress

    SortedSet<Transaction> transactions

    static hasMany = [
        licenseStates:  State,
        incentives:     Incentive,
        transactions:   Transaction
    ]

    static constraints = {
        username blank: false, unique: true
        password blank: false

        firstName nullable: true
        lastName nullable: true
        governmentId nullable: true  // TODO: regex validation?
        birthday nullable: true

        email nullable: true, email: true

        trainingStatus nullable: true, inList: ['not started', 'in progress', 'complete']

        address1 nullable: true
        address2 nullable: true
        city nullable: true
        state nullable: true
        zip nullable: true   // TODO: regex validation?

        agentId nullable: true
        licenseStates()

        contract nullable: true
        contractAddress nullable: true

        incentives()
    }

    public void setContract( Object contract ) {
        if ( contract?.id ) {
            this.contract = contract
        }
    }


}