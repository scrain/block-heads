package blockheads


import grails.rest.*
import groovy.transform.Sortable

@Sortable(includes=['dateCreated'])
@Resource(readOnly = false, formats = ['json', 'xml'])
class Transaction {
    String status

    BigDecimal faceAmount
    BigDecimal premium

    Date dateCreated
    Date lastUpdated

    static constraints = {
        status      inList: ['pending', 'complete', 'cancelled']
        faceAmount  min: 0.0
        premium     min: 0.0

        dateCreated()
        lastUpdated()
    }
    // to pending --> addToPending
    // from pending --> removeFromPending

    // to complete --> addToInforce
    // from compete --> removeFromInforce

    // to cancelled

}