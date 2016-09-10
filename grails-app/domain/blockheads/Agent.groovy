package blockheads


import grails.rest.*
import groovy.transform.Sortable

@Sortable(includes=['lastName', 'firstName'])
@Resource(readOnly = false, formats = ['json', 'xml'])
class Agent {
    String email
    String password
    String firstName
    String lastName

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

    Date contractDate

    SortedSet<Incentive> incentives

    String contractAddress

    SortedSet<Transaction> transactions

    static hasMany = [
        licenseStates:  State,
        incentives:     Incentive,
        transactions:   Transaction
    ]

    static constraints = {
        email       unique: false, blank: false, email: true
        password    blank: false

        firstName       nullable: true
        lastName        nullable: true
        governmentId    nullable: true  // TODO: regex validation?
        birthday        nullable: true

        trainingStatus nullable: true, inList: ['not started', 'in progress', 'complete']

        address1    nullable: true
        address2    nullable: true
        city        nullable: true
        state       nullable: true
        zip         nullable: true   // TODO: regex validation?

        agentId nullable: true
        licenseStates()

        contract nullable: true
        contractDate nullable: true
        contractAddress nullable: true

        incentives()
    }

    static fetchMode = [contract: 'eager', transactions: 'eager']
}