import blockheads.Incentive
import blockheads.State

class BootStrap {

    def init = { servletContext ->
        new State(name:'KS').save(failOnError: true)
        new State(name:'MO').save(failOnError: true)
        new State(name:'IL').save(failOnError: true)

        new Incentive(name:'Xbox Xtravaganza!!!', reward:'Xbox', description:'blah', type: 'foo', amount: 1000.00, term: '1 month').save(failOnError:true)
    }
    def destroy = {
    }
}
