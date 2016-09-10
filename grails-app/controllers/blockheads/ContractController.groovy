package blockheads

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ContractController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 1000, 10000)
        respond Contract.list(params), model:[contractCount: Contract.count()]
    }

    def show(Contract contract) {
        respond contract
    }

    @Transactional
    def save(Contract contract) {
        if (contract == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (contract.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contract.errors, view:'create'
            return
        }

        contract.save flush:true

        respond contract, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Contract contract) {
        if (contract == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (contract.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contract.errors, view:'edit'
            return
        }

        contract.save flush:true

        respond contract, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Contract contract) {

        if (contract == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        contract.delete flush:true

        render status: NO_CONTENT
    }
}
