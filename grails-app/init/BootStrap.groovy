import blockheads.Agent
import blockheads.Contract
import blockheads.Incentive
import blockheads.State

class BootStrap {

    def init = { servletContext ->

        def stateAL = new State(name:'AL').save(failOnError: true)
        def stateAK = new State(name:'AK').save(failOnError: true)
        def stateAZ = new State(name:'AZ').save(failOnError: true)
        def stateAR = new State(name:'AR').save(failOnError: true)
        def stateCA = new State(name:'CA').save(failOnError: true)
        def stateCO = new State(name:'CO').save(failOnError: true)
        def stateCT = new State(name:'CT').save(failOnError: true)
        def stateDE = new State(name:'DE').save(failOnError: true)
        def stateFL = new State(name:'FL').save(failOnError: true)
        def stateGA = new State(name:'GA').save(failOnError: true)
        def stateHI = new State(name:'HI').save(failOnError: true)
        def stateID = new State(name:'ID').save(failOnError: true)
        def stateIL = new State(name:'IL').save(failOnError: true)
        def stateIN = new State(name:'IN').save(failOnError: true)
        def stateIA = new State(name:'IA').save(failOnError: true)
        def stateKS = new State(name:'KS').save(failOnError: true)
        def stateKY = new State(name:'KY').save(failOnError: true)
        def stateLA = new State(name:'LA').save(failOnError: true)
        def stateME = new State(name:'ME').save(failOnError: true)
        def stateMD = new State(name:'MD').save(failOnError: true)
        def stateMA = new State(name:'MA').save(failOnError: true)
        def stateMI = new State(name:'MI').save(failOnError: true)
        def stateMN = new State(name:'MN').save(failOnError: true)
        def stateMS = new State(name:'MS').save(failOnError: true)
        def stateMO = new State(name:'MO').save(failOnError: true)
        def stateMT = new State(name:'MT').save(failOnError: true)
        def stateNE = new State(name:'NE').save(failOnError: true)
        def stateNV = new State(name:'NV').save(failOnError: true)
        def stateNH = new State(name:'NH').save(failOnError: true)
        def stateNJ = new State(name:'NJ').save(failOnError: true)
        def stateNM = new State(name:'NM').save(failOnError: true)
        def stateNY = new State(name:'NY').save(failOnError: true)
        def stateNC = new State(name:'NC').save(failOnError: true)
        def stateND = new State(name:'ND').save(failOnError: true)
        def stateOH = new State(name:'OH').save(failOnError: true)
        def stateOK = new State(name:'OK').save(failOnError: true)
        def stateOR = new State(name:'OR').save(failOnError: true)
        def statePA = new State(name:'PA').save(failOnError: true)
        def stateRI = new State(name:'RI').save(failOnError: true)
        def stateSC = new State(name:'SC').save(failOnError: true)
        def stateSD = new State(name:'SD').save(failOnError: true)
        def stateTN = new State(name:'TN').save(failOnError: true)
        def stateTX = new State(name:'TX').save(failOnError: true)
        def stateUT = new State(name:'UT').save(failOnError: true)
        def stateVT = new State(name:'VT').save(failOnError: true)
        def stateVA = new State(name:'VA').save(failOnError: true)
        def stateWA = new State(name:'WA').save(failOnError: true)
        def stateWV = new State(name:'WV').save(failOnError: true)
        def stateWI = new State(name:'WI').save(failOnError: true)
        def stateWY = new State(name:'WY').save(failOnError: true)

        Contract fiftyFiveKTwoYears = new Contract(
            name: '55K for two years',
            description: '$55,000 premium sold for two years',
            type: 'Fixed Duration',
            amount: 55000.00,
            term: '2 year',
            frequency: 'Annually',
            maxPayout: 10000.00
        ).save(failOnError:true)
		
		Contract thirtySixKThreeYears = new Contract(
            name: '36K for three years',
            description: '$36,000 premium sold for three years',
            type: 'Fixed Duration',
            amount: 36000.00,
            term: '3 year',
            frequency: 'Annually',
            maxPayout: 10000.00
        ).save(failOnError:true)
		
		Contract twentyThreeKFiveYears = new Contract(
            name: '23K for five years',
            description: '$23,000 premium sold for five years',
            type: 'Fixed Duration',
            amount: 23000.00,
            term: '5 year',
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
