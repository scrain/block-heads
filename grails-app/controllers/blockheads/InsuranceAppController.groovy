package blockheads

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class InsuranceAppController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 1000, 10000)
        respond InsuranceApp.list(params), model:[insuranceAppCount: InsuranceApp.count()]
    }

    def show(InsuranceApp insuranceApp) {
        respond insuranceApp
    }

    @Transactional
    def save(InsuranceApp insuranceApp) {
        if (insuranceApp == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (insuranceApp.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond insuranceApp.errors, view:'create'
            return
        }

        insuranceApp.save flush:true

        respond insuranceApp, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(InsuranceApp insuranceApp) {
        if (insuranceApp == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (insuranceApp.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond insuranceApp.errors, view:'edit'
            return
        }

        insuranceApp.save flush:true

        respond insuranceApp, [status: OK, view:"show"]
    }

    @Transactional
    def delete(InsuranceApp insuranceApp) {

        if (insuranceApp == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        insuranceApp.delete flush:true

        render status: NO_CONTENT
    }
}
