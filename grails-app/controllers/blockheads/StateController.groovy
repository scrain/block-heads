package blockheads

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class StateController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond State.list(params), model:[stateCount: State.count()]
    }

    def show(State state) {
        respond state
    }

    @Transactional
    def save(State state) {
        if (state == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (state.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond state.errors, view:'create'
            return
        }

        state.save flush:true

        respond state, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(State state) {
        if (state == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (state.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond state.errors, view:'edit'
            return
        }

        state.save flush:true

        respond state, [status: OK, view:"show"]
    }

    @Transactional
    def delete(State state) {

        if (state == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        state.delete flush:true

        render status: NO_CONTENT
    }
}
