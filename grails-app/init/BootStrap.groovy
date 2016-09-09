import blockheads.Agent
import blockheads.Contract
import blockheads.Incentive
import blockheads.State

class BootStrap {

    def init = { servletContext ->

        def stateKS = new State(name:'KS').save(failOnError: true)
        def stateMO = new State(name:'MO').save(failOnError: true)
        def stateIL = new State(name:'IL').save(failOnError: true)

        Contract oneMilTwoYears = new Contract(
            name: '1 million for two years',
            description: '1 million for two years',
            type: 'Fixed Duration',
            amount: 1000000.00,
            term: '2 years',
            frequency: 'Annually',
            maxPayout: 50000.00
        ).save(failOnError:true)

        def jdoe = new Agent(
            username: 'jdoe',
            password: 'demo',
            firstName: 'John',
            lastName: 'Doe',
            governmentId: '123-45-6789',
            birthday: new Date(),
            email: 'jdoe@gmail.com',
            trainingStatus: 'complete',
            address1: '123 Oak Lane',
            city: 'Chesterfield',
            state: stateMO,
            zip: '62294',
            agentId: '123456',
            licenseStates: stateMO,
            contract: oneMilTwoYears,
            incentives: [],
            transactions: []
        ).save(failOnError:true)

        new Incentive(name:'Xbox Xtravaganza!!!', reward:'Xbox', description:'blah', type: 'foo', amount: 1000.00, term: '1 month').save(failOnError:true)
    }
    def destroy = {
    }
}
