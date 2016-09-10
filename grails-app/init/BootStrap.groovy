import blockheads.Agent
import blockheads.Contract
import blockheads.Incentive
import blockheads.InsuranceApp
import blockheads.State
import blockheads.Transaction

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

        Contract none = new Contract(
            name: 'none',
            description: 'none',
            type: 'Fixed Duration',
            amount: 0.00,
            term: '5 year',
            frequency: 'Annually',
            maxPayout: 0.0
        ).save(failOnError:true)

        def jdoe = new Agent(
            password: 'demo',
            firstName: 'John',
            lastName: 'Doe',
            governmentId: '123-45-6789',
            birthday: new Date('02/14/1996'),
            email: 'jdoe@gmail.com',
            trainingStatus: 'complete',
            address1: '123 Oak Lane',
            city: 'Chesterfield',
            state: stateMO,
            zip: '62294',
            agentId: '123456',
            licenseStates: stateMO,
            contract: fiftyFiveKTwoYears,
            contractDate: new Date('11/14/2015'),
            contractAddress: '21234124124',
            incentives: [],
            transactions: []
        ).save(failOnError:true)

        def fflintstone = new Agent(
            password: 'bedrock',
            firstName: 'Fred',
            lastName: 'Flintstone',
            governmentId: '002-33-4444',
            birthday: new Date('10/19/1983'),
            email: 'fflinstone@aol.com',
            trainingStatus: 'complete',
            address1: '123 Quarry Lane',
            city: 'Bedrock',
            state: stateMO,
            zip: '63141',
            agentId: '677325',
            licenseStates: stateMO,
            contract: twentyThreeKFiveYears,
            contractDate: new Date('10/07/2014'),
            contractAddress: '21234124124',
            incentives: [],
            transactions: []
        ).save(failOnError:true)
		
		def hsimpson = new Agent(
            password: 'donut',
            firstName: 'Homer',
            lastName: 'Simpson',
            governmentId: '555-55-5555',
            birthday: new Date('03/17/1997'),
            email: 'hsimpson@gmail.com',
            trainingStatus: 'in progress',
            address1: '742 Evergreen Terrace',
            city: 'Springfield',
            state: stateMO,
            zip: '63376',
            agentId: '977443',
            licenseStates: stateIL,
            contract: thirtySixKThreeYears,
            contractDate: new Date('01/07/2016'),
            contractAddress: '21234124124',
            incentives: [],
            transactions: []
        ).save(failOnError:true)

        def freshman = new Agent(
                password: 'demo',
                firstName: 'Skip',
                lastName: 'Johnson',
                governmentId: '123-45-6789',
                birthday: new Date(),
                email: 'skippy@gmail.com',
                trainingStatus: 'complete',
                address1: '21 Jump Street',
                city: 'Chesterfield',
                state: stateMO,
                zip: '62294',
                agentId: '123456',
                licenseStates: stateMO,
                incentives: [],
                transactions: []
        ).save(failOnError:true)

        new Incentive(name:'Xbox Xtravaganza!!!', reward:'Xbox', description:'blah', type: 'foo', amount: 1000.00, term: '1 month').save(failOnError:true)


        def insApp_123456_26783455R = new InsuranceApp(
            number: '26783455R',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Peter Cottontail',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_677325_26783897T = new InsuranceApp(
            number: '26783897T',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Jill E Cupcake',
            status: 'issued',
            issueDate: new Date('09/01/2016'),
        ).save(failOnError:true)
        def insApp_977443_34462810S = new InsuranceApp(
            number: '34462810S',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Ted Drew',
            status: 'issued'
        ).save(failOnError:true)
        def insApp_123456_78229104 = new InsuranceApp(
            number: '78229104',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Adam Young',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_677325_829R28710 = new InsuranceApp(
            number: '829R28710',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Jennifer Stewart',
            status: 'issued',
            issueDate: new Date('09/02/2016'),
        ).save(failOnError:true)
        def insApp_123456_7S018309U = new InsuranceApp(
            number: '7S018309U',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Joseph Coleman',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_19927010E = new InsuranceApp(
            number: '19927010E',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Edward Howard',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_977443_34097917254 = new InsuranceApp(
            number: '34097917254',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '977443',
            planType: 'Universal Life',
            insuredName: 'Eugene Reed',
            status: 'issued',
            issueDate: new Date('09/03/2016'),
        ).save(failOnError:true)
        def insApp_677325_137987J34 = new InsuranceApp(
            number: '137987J34',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '677325',
            planType: '20 Year Term',
            insuredName: 'Terry Wilson',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_1098801N = new InsuranceApp(
            number: '1098801N',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Kathy Lee',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_458790200S = new InsuranceApp(
            number: '458790200S',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Kevin Nelson',
            status: 'issued',
            issueDate: new Date('09/04/2016'),
        ).save(failOnError:true)
        def insApp_977443_9087N3409 = new InsuranceApp(
            number: '9087N3409',
            faceAmount: 500000.00,
            premium: 1420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Roger Foster',
            status: 'issued'
        ).save(failOnError:true)
        def insApp_677325_854662920N = new InsuranceApp(
            number: '854662920N',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '677325',
            planType: '30 Year Term',
            insuredName: 'Nicholas Cooper',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_774939277J = new InsuranceApp(
            number: '774939277J',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Nancy Martin',
            status: 'issued',
            issueDate: new Date('09/01/2016'),
        ).save(failOnError:true)
        def insApp_123456_749277J146 = new InsuranceApp(
            number: '749277J146',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Bruce Perry',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_777436376 = new InsuranceApp(
            number: '777436376',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Chris Thomas',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_677325_854746080 = new InsuranceApp(
            number: '854746080',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Thomas Morris',
            status: 'issued',
            issueDate: new Date('08/01/2016'),
        ).save(failOnError:true)
        def insApp_977443_187206691 = new InsuranceApp(
            number: '187206691',
            faceAmount: 500000.00,
            premium: 1420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Christina Smith',
            status: 'issued'
        ).save(failOnError:true)
        def insApp_123456_518684258 = new InsuranceApp(
            number: '518684258',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Christine Ross',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_677325_285064948 = new InsuranceApp(
            number: '285064948',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Frank Baker',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_876705297 = new InsuranceApp(
            number: '876705297',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Robert Gonzales',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_499335805 = new InsuranceApp(
            number: '499335805',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Keith Rodriguez',
            status: 'issued',
            issueDate: new Date('08/15/2016'),
        ).save(failOnError:true)
        def insApp_977443_120914675 = new InsuranceApp(
            number: '120914675',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '977443',
            planType: 'Universal Life',
            insuredName: 'Phyllis Phillips',
            status: 'issued',
            issueDate: new Date('08/01/2016'),
        ).save(failOnError:true)
        def insApp_677325_608476479 = new InsuranceApp(
            number: '608476479',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '677325',
            planType: '20 Year Term',
            insuredName: 'Bobby Sanchez',
            status: 'issued',
            issueDate: new Date('07/05/2016'),
        ).save(failOnError:true)
        def insApp_123456_382881935 = new InsuranceApp(
            number: '382881935',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Ronald Jenkins',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_100291470 = new InsuranceApp(
            number: '100291470',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Harold Wood',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_977443_920641311 = new InsuranceApp(
            number: '920641311',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Judy Powell',
            status: 'issued'
        ).save(failOnError:true)
        def insApp_677325_644269829 = new InsuranceApp(
            number: '644269829',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '677325',
            planType: '30 Year Term',
            insuredName: 'Douglas Hughes',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_273115471 = new InsuranceApp(
            number: '273115471',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Rachel Brown',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_101536046 = new InsuranceApp(
            number: '101536046',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Margaret Davis',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_159224057 = new InsuranceApp(
            number: '159224057',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Jack Murphy',
            status: 'issued',
            issueDate: new Date('06/01/2016'),
        ).save(failOnError:true)
        def insApp_677325_473318404 = new InsuranceApp(
            number: '473318404',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Roy Johnson',
            status: 'issued',
            issueDate: new Date('08/06/2016'),
        ).save(failOnError:true)
        def insApp_977443_509416726 = new InsuranceApp(
            number: '509416726',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Timothy Russell',
            status: 'issued',
            issueDate: new Date('05/02/2016'),
        ).save(failOnError:true)
        def insApp_123456_522134487 = new InsuranceApp(
            number: '522134487',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Debra Martinez',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_677325_863550812 = new InsuranceApp(
            number: '863550812',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Howard Rogers',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_379216027 = new InsuranceApp(
            number: '379216027',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Sarah Cook',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_790169772 = new InsuranceApp(
            number: '790169772',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Shawn Gonzalez',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_977443_553862369 = new InsuranceApp(
            number: '553862369',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '977443',
            planType: 'Universal Life',
            insuredName: 'Martha Cox',
            status: 'issued'
        ).save(failOnError:true)
        def insApp_677325_900653645 = new InsuranceApp(
            number: '900653645',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '677325',
            planType: '20 Year Term',
            insuredName: 'Justin Jones',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_345920014 = new InsuranceApp(
            number: '345920014',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Eric Robinson',
            status: 'issued',
            issueDate: new Date('08/07/2016'),
        ).save(failOnError:true)
        def insApp_123456_408217685 = new InsuranceApp(
            number: '408217685',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Janice Diaz',
            status: 'issued',
            issueDate: new Date('02/01/2016'),
        ).save(failOnError:true)
        def insApp_977443_956047332 = new InsuranceApp(
            number: '956047332',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Alan Barnes',
            status: 'issued',
            issueDate: new Date('03/02/2016'),
        ).save(failOnError:true)
        def insApp_677325_544968478 = new InsuranceApp(
            number: '544968478',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '677325',
            planType: '30 Year Term',
            insuredName: 'Tina Carter',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_652125247 = new InsuranceApp(
            number: '652125247',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Dennis Green',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_240781384 = new InsuranceApp(
            number: '240781384',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Donna Wright',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_908988383 = new InsuranceApp(
            number: '908988383',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Paula Campbell',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_677325_199100643 = new InsuranceApp(
            number: '199100643',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Johnny Peterson',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_977443_144849956 = new InsuranceApp(
            number: '144849956',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'George King',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_991242981 = new InsuranceApp(
            number: '991242981',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Clarence Morgan',
            status: 'issued',
            issueDate: new Date('04/05/2016'),
        ).save(failOnError:true)
        def insApp_677325_244786222 = new InsuranceApp(
            number: '244786222',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Russell Price',
            status: 'issued',
            issueDate: new Date('07/05/2016'),
        ).save(failOnError:true)
        def insApp_123456_971937836 = new InsuranceApp(
            number: '971937836',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Bonnie Edwards',
            status: 'issued',
            issueDate: new Date('04/03/2016'),
        ).save(failOnError:true)
        def insApp_123456_313121063 = new InsuranceApp(
            number: '313121063',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Ernest Lewis',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_977443_976997505 = new InsuranceApp(
            number: '976997505',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '977443',
            planType: 'Universal Life',
            insuredName: 'Jason Sanders',
            status: 'issued'
        ).save(failOnError:true)
        def insApp_677325_388931298 = new InsuranceApp(
            number: '388931298',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '677325',
            planType: '20 Year Term',
            insuredName: 'Phillip Bell',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_448741979 = new InsuranceApp(
            number: '448741979',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Aaron Alexander',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_465573391 = new InsuranceApp(
            number: '465573391',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Janet White',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_977443_959609105 = new InsuranceApp(
            number: '959609105',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Amanda Miller',
            status: 'issued'
        ).save(failOnError:true)
        def insApp_677325_706357237 = new InsuranceApp(
            number: '706357237',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '677325',
            planType: '30 Year Term',
            insuredName: 'Lisa Washington',
            status: 'issued',
            issueDate: new Date('07/08/2016'),
        ).save(failOnError:true)
        def insApp_123456_461129825 = new InsuranceApp(
            number: '461129825',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Cynthia Evans',
            status: 'issued',
            issueDate: new Date('03/01/2016'),
        ).save(failOnError:true)
        def insApp_123456_899308374 = new InsuranceApp(
            number: '899308374',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Henry Perez',
            status: 'issued',
            issueDate: new Date('02/03/2016'),
        ).save(failOnError:true)
        def insApp_123456_722091255 = new InsuranceApp(
            number: '722091255',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Sara Hall',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_677325_708144556 = new InsuranceApp(
            number: '708144556',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Billy Moore',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_977443_513564486 = new InsuranceApp(
            number: '513564486',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Lois Jackson',
            status: 'issued'
        ).save(failOnError:true)
        def insApp_123456_131598559 = new InsuranceApp(
            number: '131598559',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Linda Watson',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_677325_366289770 = new InsuranceApp(
            number: '366289770',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Carolyn Flores',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_641437113 = new InsuranceApp(
            number: '641437113',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Diana Hernandez',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_988581649 = new InsuranceApp(
            number: '988581649',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Susan Long',
            status: 'issued',
            issueDate: new Date('07/06/2016'),
        ).save(failOnError:true)
        def insApp_977443_847731652 = new InsuranceApp(
            number: '847731652',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '977443',
            planType: 'Universal Life',
            insuredName: 'Andrew Roberts',
            status: 'issued',
            issueDate: new Date('04/02/2016'),
        ).save(failOnError:true)
        def insApp_677325_895849383 = new InsuranceApp(
            number: '895849383',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '677325',
            planType: '20 Year Term',
            insuredName: 'Laura Bailey',
            status: 'issued',
            issueDate: new Date('01/04/2016'),
        ).save(failOnError:true)
        def insApp_123456_528987269 = new InsuranceApp(
            number: '528987269',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Irene Brooks',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_637872077 = new InsuranceApp(
            number: '637872077',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Andrea Simmons',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_977443_903115686 = new InsuranceApp(
            number: '903115686',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Christopher Mitchell',
            status: 'issued'
        ).save(failOnError:true)
        def insApp_677325_836709292 = new InsuranceApp(
            number: '836709292',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '677325',
            planType: '30 Year Term',
            insuredName: 'Anna Kelly',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_598495348 = new InsuranceApp(
            number: '598495348',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Ruth Allen',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_691684668 = new InsuranceApp(
            number: '691684668',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Rose Garcia',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_981745262 = new InsuranceApp(
            number: '981745262',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Stephen Walker',
            status: 'issued',
            issueDate: new Date('05/03/2016'),
        ).save(failOnError:true)
        def insApp_677325_815258544 = new InsuranceApp(
            number: '815258544',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'James Anderson',
            status: 'issued',
            issueDate: new Date('02/06/2016'),
        ).save(failOnError:true)
        def insApp_977443_252574256 = new InsuranceApp(
            number: '252574256',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Jean Parker',
            status: 'issued',
            issueDate: new Date('03/04/2016'),
        ).save(failOnError:true)
        def insApp_123456_795486292 = new InsuranceApp(
            number: '795486292',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Philip Scott',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_677325_856784422 = new InsuranceApp(
            number: '856784422',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '677325',
            planType: 'Universal Life',
            insuredName: 'Julie Thompson',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_107413216 = new InsuranceApp(
            number: '107413216',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Daniel Bryant',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_980396916 = new InsuranceApp(
            number: '980396916',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'Carol Williams',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_977443_546284497 = new InsuranceApp(
            number: '546284497',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '977443',
            planType: 'Universal Life',
            insuredName: 'Larry Lopez',
            status: 'issued'
        ).save(failOnError:true)
        def insApp_677325_984060487 = new InsuranceApp(
            number: '984060487',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '677325',
            planType: '20 Year Term',
            insuredName: 'David Griffin',
            status: 'pending'
        ).save(failOnError:true)
        def insApp_123456_803837222 = new InsuranceApp(
            number: '803837222',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '123456',
            planType: '30 Year Term',
            insuredName: 'William Rivera',
            status: 'issued',
            issueDate: new Date('08/07/2016'),
        ).save(failOnError:true)
        def insApp_123456_678249193 = new InsuranceApp(
            number: '678249193',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Kathleen Clark',
            status: 'issued',
            issueDate: new Date('05/04/2016'),
        ).save(failOnError:true)
        def insApp_977443_247964274 = new InsuranceApp(
            number: '247964274',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '977443',
            planType: '20 Year Term',
            insuredName: 'Gregory James',
            status: 'issued',
            issueDate: new Date('03/02/2016'),
        ).save(failOnError:true)
        def insApp_677325_998353781 = new InsuranceApp(
            number: '998353781',
            faceAmount: 1000000.00,
            premium: 888.00,
            agentId: '677325',
            planType: '30 Year Term',
            insuredName: 'Jimmy Hill',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_362401237 = new InsuranceApp(
            number: '362401237',
            faceAmount: 250000.00,
            premium: 624.00,
            agentId: '123456',
            planType: 'Universal Life',
            insuredName: 'Donald Gray',
            status: 'declined'
        ).save(failOnError:true)
        def insApp_123456_252059328 = new InsuranceApp(
            number: '252059328',
            faceAmount: 500000.00,
            premium: 420.00,
            agentId: '123456',
            planType: '20 Year Term',
            insuredName: 'Ashley Turner',
            status: 'declined'
        ).save(failOnError:true)


        def trans_123456_26783455R = new Transaction(
            applicationNumber: '26783455R',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_26783897T = new Transaction(
            applicationNumber: '26783897T',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_34462810S = new Transaction(
            applicationNumber: '34462810S',
            status: 'cancelled',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_78229104 = new Transaction(
            applicationNumber: '78229104',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_829R28710 = new Transaction(
            applicationNumber: '829R28710',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_7S018309U = new Transaction(
            applicationNumber: '7S018309U',
            status: 'cancelled',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_19927010E = new Transaction(
            applicationNumber: '19927010E',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_977443_34097917254 = new Transaction(
            applicationNumber: '34097917254',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_677325_137987J34 = new Transaction(
            applicationNumber: '137987J34',
            status: 'cancelled',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_1098801N = new Transaction(
            applicationNumber: '1098801N',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_458790200S = new Transaction(
            applicationNumber: '458790200S',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_9087N3409 = new Transaction(
            applicationNumber: '9087N3409',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_677325_854662920N = new Transaction(
            applicationNumber: '854662920N',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_774939277J = new Transaction(
            applicationNumber: '774939277J',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_749277J146 = new Transaction(
            applicationNumber: '749277J146',
            status: 'cancelled',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_777436376 = new Transaction(
            applicationNumber: '777436376',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_854746080 = new Transaction(
            applicationNumber: '854746080',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_187206691 = new Transaction(
            applicationNumber: '187206691',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_518684258 = new Transaction(
            applicationNumber: '518684258',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_285064948 = new Transaction(
            applicationNumber: '285064948',
            status: 'pending',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_876705297 = new Transaction(
            applicationNumber: '876705297',
            status: 'pending',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_499335805 = new Transaction(
            applicationNumber: '499335805',
            status: 'complete',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_977443_120914675 = new Transaction(
            applicationNumber: '120914675',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_677325_608476479 = new Transaction(
            applicationNumber: '608476479',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_382881935 = new Transaction(
            applicationNumber: '382881935',
            status: 'cancelled',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_100291470 = new Transaction(
            applicationNumber: '100291470',
            status: 'cancelled',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_920641311 = new Transaction(
            applicationNumber: '920641311',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_677325_644269829 = new Transaction(
            applicationNumber: '644269829',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_273115471 = new Transaction(
            applicationNumber: '273115471',
            status: 'pending',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_101536046 = new Transaction(
            applicationNumber: '101536046',
            status: 'pending',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_159224057 = new Transaction(
            applicationNumber: '159224057',
            status: 'complete',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_473318404 = new Transaction(
            applicationNumber: '473318404',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_509416726 = new Transaction(
            applicationNumber: '509416726',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_522134487 = new Transaction(
            applicationNumber: '522134487',
            status: 'cancelled',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_863550812 = new Transaction(
            applicationNumber: '863550812',
            status: 'cancelled',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_379216027 = new Transaction(
            applicationNumber: '379216027',
            status: 'cancelled',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_790169772 = new Transaction(
            applicationNumber: '790169772',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_977443_553862369 = new Transaction(
            applicationNumber: '553862369',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_677325_900653645 = new Transaction(
            applicationNumber: '900653645',
            status: 'pending',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_345920014 = new Transaction(
            applicationNumber: '345920014',
            status: 'complete',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_408217685 = new Transaction(
            applicationNumber: '408217685',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_956047332 = new Transaction(
            applicationNumber: '956047332',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_677325_544968478 = new Transaction(
            applicationNumber: '544968478',
            status: 'cancelled',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_652125247 = new Transaction(
            applicationNumber: '652125247',
            status: 'cancelled',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_240781384 = new Transaction(
            applicationNumber: '240781384',
            status: 'cancelled',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_908988383 = new Transaction(
            applicationNumber: '908988383',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_199100643 = new Transaction(
            applicationNumber: '199100643',
            status: 'pending',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_144849956 = new Transaction(
            applicationNumber: '144849956',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_991242981 = new Transaction(
            applicationNumber: '991242981',
            status: 'complete',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_244786222 = new Transaction(
            applicationNumber: '244786222',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_971937836 = new Transaction(
            applicationNumber: '971937836',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_313121063 = new Transaction(
            applicationNumber: '313121063',
            status: 'cancelled',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_977443_976997505 = new Transaction(
            applicationNumber: '976997505',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_677325_388931298 = new Transaction(
            applicationNumber: '388931298',
            status: 'cancelled',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_448741979 = new Transaction(
            applicationNumber: '448741979',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_465573391 = new Transaction(
            applicationNumber: '465573391',
            status: 'pending',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_959609105 = new Transaction(
            applicationNumber: '959609105',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_677325_706357237 = new Transaction(
            applicationNumber: '706357237',
            status: 'complete',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_461129825 = new Transaction(
            applicationNumber: '461129825',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_899308374 = new Transaction(
            applicationNumber: '899308374',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_722091255 = new Transaction(
            applicationNumber: '722091255',
            status: 'cancelled',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_708144556 = new Transaction(
            applicationNumber: '708144556',
            status: 'cancelled',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_513564486 = new Transaction(
            applicationNumber: '513564486',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_131598559 = new Transaction(
            applicationNumber: '131598559',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_366289770 = new Transaction(
            applicationNumber: '366289770',
            status: 'pending',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_641437113 = new Transaction(
            applicationNumber: '641437113',
            status: 'pending',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_988581649 = new Transaction(
            applicationNumber: '988581649',
            status: 'complete',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_977443_847731652 = new Transaction(
            applicationNumber: '847731652',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_677325_895849383 = new Transaction(
            applicationNumber: '895849383',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_528987269 = new Transaction(
            applicationNumber: '528987269',
            status: 'cancelled',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_637872077 = new Transaction(
            applicationNumber: '637872077',
            status: 'cancelled',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_903115686 = new Transaction(
            applicationNumber: '903115686',
            status: 'cancelled',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_677325_836709292 = new Transaction(
            applicationNumber: '836709292',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_598495348 = new Transaction(
            applicationNumber: '598495348',
            status: 'pending',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_691684668 = new Transaction(
            applicationNumber: '691684668',
            status: 'pending',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_981745262 = new Transaction(
            applicationNumber: '981745262',
            status: 'complete',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_815258544 = new Transaction(
            applicationNumber: '815258544',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_252574256 = new Transaction(
            applicationNumber: '252574256',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_795486292 = new Transaction(
            applicationNumber: '795486292',
            status: 'cancelled',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_677325_856784422 = new Transaction(
            applicationNumber: '856784422',
            status: 'cancelled',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_107413216 = new Transaction(
            applicationNumber: '107413216',
            status: 'cancelled',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_980396916 = new Transaction(
            applicationNumber: '980396916',
            status: 'pending',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_977443_546284497 = new Transaction(
            applicationNumber: '546284497',
            status: 'pending',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_677325_984060487 = new Transaction(
            applicationNumber: '984060487',
            status: 'pending',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_123456_803837222 = new Transaction(
            applicationNumber: '803837222',
            status: 'complete',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_678249193 = new Transaction(
            applicationNumber: '678249193',
            status: 'complete',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_977443_247964274 = new Transaction(
            applicationNumber: '247964274',
            status: 'complete',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)
        def trans_677325_998353781 = new Transaction(
            applicationNumber: '998353781',
            status: 'cancelled',
            faceAmount: 1000000.00,
            premium: 888.00
        ).save(failOnError:true)
        def trans_123456_362401237 = new Transaction(
            applicationNumber: '362401237',
            status: 'cancelled',
            faceAmount: 250000.00,
            premium: 624.00
        ).save(failOnError:true)
        def trans_123456_252059328 = new Transaction(
            applicationNumber: '252059328',
            status: 'cancelled',
            faceAmount: 500000.00,
            premium: 420.00
        ).save(failOnError:true)

        Agent.findByAgentId('123456').addToTransactions(trans_123456_26783455R).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_26783897T).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_34462810S).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_78229104).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_829R28710).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_7S018309U).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_19927010E).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_34097917254).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_137987J34).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_1098801N).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_458790200S).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_9087N3409).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_854662920N).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_774939277J).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_749277J146).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_777436376).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_854746080).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_187206691).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_518684258).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_285064948).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_876705297).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_499335805).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_120914675).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_608476479).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_382881935).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_100291470).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_920641311).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_644269829).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_273115471).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_101536046).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_159224057).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_473318404).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_509416726).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_522134487).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_863550812).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_379216027).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_790169772).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_553862369).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_900653645).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_345920014).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_408217685).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_956047332).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_544968478).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_652125247).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_240781384).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_908988383).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_199100643).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_144849956).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_991242981).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_244786222).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_971937836).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_313121063).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_976997505).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_388931298).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_448741979).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_465573391).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_959609105).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_706357237).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_461129825).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_899308374).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_722091255).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_708144556).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_513564486).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_131598559).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_366289770).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_641437113).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_988581649).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_847731652).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_895849383).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_528987269).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_637872077).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_903115686).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_836709292).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_598495348).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_691684668).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_981745262).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_815258544).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_252574256).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_795486292).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_856784422).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_107413216).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_980396916).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_546284497).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_984060487).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_803837222).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_678249193).save(failOnError:true)
        Agent.findByAgentId('977443').addToTransactions(trans_977443_247964274).save(failOnError:true)
        Agent.findByAgentId('677325').addToTransactions(trans_677325_998353781).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_362401237).save(failOnError:true)
        Agent.findByAgentId('123456').addToTransactions(trans_123456_252059328).save(failOnError:true)    }


    def destroy = {
    }
}
