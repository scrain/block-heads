package blockheads


import grails.rest.*
import groovy.transform.Sortable

@Sortable(includes=['name'])
@Resource(readOnly = false, formats = ['json', 'xml'])
class Contract {
    String name

    String description

    String type

    BigDecimal amount
    String term
    String frequency

    BigDecimal maxPayout

    Date dateCreated
    Date lastUpdated

    static constraints = {
        name        blank: false, unique: true
        description()

        type        blank: false, inList: ['Fixed Duration']
        amount      min: 0.0
        term        blank: false, inList: ['2 year', '3 years', '5 years' ]
        frequency   blank: false, inList: ['Quarterly', 'Annually']
        maxPayout   min: 0.0

        dateCreated()
        lastUpdated()
    }

}