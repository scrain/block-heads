import blockheads.State

class BootStrap {

    def init = { servletContext ->
        new State(name:'KS').save(failOnError: true)
        new State(name:'MO').save(failOnError: true)
        new State(name:'IL').save(failOnError: true)
    }
    def destroy = {
    }
}
