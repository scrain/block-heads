package blockheads

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TransactionController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Transaction.list(params), model:[transactionCount: Transaction.count()]
    }

    def show(Transaction transaction) {
        respond transaction
    }

    @Transactional
    def save(Transaction transaction) {
        if (transaction == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (transaction.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond transaction.errors, view:'create'
            return
        }

        transaction.save flush:true

        respond transaction, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Transaction transaction) {
        if (transaction == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (transaction.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond transaction.errors, view:'edit'
            return
        }

        transaction.save flush:true

        respond transaction, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Transaction transaction) {

        if (transaction == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        transaction.delete flush:true

        render status: NO_CONTENT
    }
}
