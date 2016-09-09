package blockheads

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class IncentiveController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Incentive.list(params), model:[incentiveCount: Incentive.count()]
    }

    def show(Incentive incentive) {
        respond incentive
    }

    @Transactional
    def save(Incentive incentive) {
        if (incentive == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (incentive.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond incentive.errors, view:'create'
            return
        }

        incentive.save flush:true

        respond incentive, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Incentive incentive) {
        if (incentive == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (incentive.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond incentive.errors, view:'edit'
            return
        }

        incentive.save flush:true

        respond incentive, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Incentive incentive) {

        if (incentive == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        incentive.delete flush:true

        render status: NO_CONTENT
    }
}
