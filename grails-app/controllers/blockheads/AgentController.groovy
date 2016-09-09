package blockheads

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AgentController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Agent.list(params), model:[agentCount: Agent.count()]
    }

    def show(Agent agent) {
        respond agent
    }

    @Transactional
    def save(Agent agent) {
        if (agent == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (agent.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond agent.errors, view:'create'
            return
        }

        agent.save flush:true

        respond agent, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Agent agent) {
        if (agent == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (agent.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond agent.errors, view:'edit'
            return
        }

        agent.save flush:true

        respond agent, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Agent agent) {

        if (agent == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        agent.delete flush:true

        render status: NO_CONTENT
    }
}
