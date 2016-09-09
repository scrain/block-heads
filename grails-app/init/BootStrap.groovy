import blockheads.Agent
import blockheads.Contract
import blockheads.Incentive
import blockheads.State

class BootStrap {

    def init = { servletContext ->

        def stateKS = new State(name:'KS').save(failOnError: true)
        def stateMO = new State(name:'MO').save(failOnError: true)
        def stateIL = new State(name:'IL').save(failOnError: true)

        Contract fiftyFiveKTwoYears = new Contract(
            name: '55K for two years',
            description: '$55,000 premium sold for two years',
            type: 'Fixed Duration',
            amount: 55000.00,
            term: '2 years',
            frequency: 'Annually',
            maxPayout: 10000.00
        ).save(failOnError:true)
		
		Contract thirtySixKThreeYears = new Contract(
            name: '36K for three years',
            description: '$36,000 premium sold for three years',
            type: 'Fixed Duration',
            amount: 36000.00,
            term: '3 years',
            frequency: 'Annually',
            maxPayout: 10000.00
        ).save(failOnError:true)
		
		Contract twentyThreeKFiveYears = new Contract(
            name: '23K for five years',
            description: '$23,000 premium sold for five years',
            type: 'Fixed Duration',
            amount: 23000.00,
            term: '5 years',
            frequency: 'Annually',
            maxPayout: 10000.00
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
            contract: fiftyFiveKTwoYears,
            incentives: [],
            transactions: []
        ).save(failOnError:true)
		
        def fflintstone = new Agent(
            username: 'fflintstone',
            password: 'bedrock',
            firstName: 'Fred',
            lastName: 'Flintstone',
            governmentId: '002-33-4444',
            birthday: new Date(),
            email: 'fflinstone@gmail.com',
            trainingStatus: 'complete',
            address1: '123 Quarry Lane',
            city: 'Bedrock',
            state: stateMO,
            zip: '63141',
            agentId: '67732',
            licenseStates: stateMO,
            contract: twentyThreeKFiveYears,
            incentives: [],
            transactions: []
        ).save(failOnError:true)
		
		def hsimpson = new Agent(
            username: 'hsimpson',
            password: 'donut',
            firstName: 'Homer',
            lastName: 'Simpson',
            governmentId: '555-55-5555',
            birthday: new Date(),
            email: 'hsimpson@gmail.com',
            trainingStatus: 'in progress',
            address1: '742 Evergreen Terrace',
            city: 'Springfield',
            state: stateMO,
            zip: '63376',
            agentId: '97744',
            licenseStates: stateMO,
            contract: thirtySixKThreeYears,
            incentives: [],
            transactions: []
        ).save(failOnError:true)

        new Incentive(name:'Xbox Xtravaganza!!!', reward:'Xbox', description:'blah', type: 'foo', amount: 1000.00, term: '1 month').save(failOnError:true)
    }
    def destroy = {
    }
}
