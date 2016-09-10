package blockheads

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AgentController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 1000, 10000)
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

        respond agent, [status: CREATED, view:"edit"]  // after step 1  go to step 2
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

        if ( ! agent.contract?.id ) {
            agent.contract = null
        }

        agent.save flush:true

        respond agent, [status: OK, view:"select-contract"] // step 2 to step 3
    }

    @Transactional
    def updateContract(Agent agent) {
        if (agent == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (agent.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond agent.errors, view:'select-contract'
            return
        }

        agent.save flush:true

        respond agent, [status: OK, view:"complete"] // step 3 to show agent
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
