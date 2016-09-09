package blockheads


import grails.rest.*

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

    static hasMany = [licenseStates: State]

    static constraints = {
        username blank: false
        password blank: false
        firstName blank: false
        lastName blank: false
        governmentId blank: false  // TODO: regex validation?
        birthday()

        email blank: false, email: true

        trainingStatus inList: ['not started', 'in progress', 'complete']

        address1 blank: false
        address2()
        city blank: false
        state()
        zip()   // TODO: regex validation?

        agentId nullable: true
        licenseStates()
    }
}