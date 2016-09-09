package blockheads


import grails.rest.*
import groovy.transform.Sortable

@Sortable(includes=['number'])
@Resource(readOnly = false, formats = ['json', 'xml'])
class InsuranceApp {
    String number

    BigDecimal faceAmount
    BigDecimal premium

    String agentId
    String planType
    String insuredName
    String status

    Date issueDate
    Date dateCreated
    Date lastUpdated

    static constraints = {
        number unique: true
        faceAmount min: 0.0
        premium min: 0.0

        agentId blank: false
        planType blank: false, inList: ['Term', 'foo']
        insuredName blank: false
        status blank: false, inList: ['pending', 'issued', 'declined']

        issueDate nullable: true
        dateCreated()
        lastUpdated()
    }
}