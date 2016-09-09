package blockheads


import grails.rest.*
import groovy.transform.Sortable

@Sortable( includes = ['name'])
@Resource(readOnly = false, formats = ['json', 'xml'])
class Incentive {
    String name
    String reward
    String description
    String type

    BigDecimal amount
    String     term

    static constraints = {
        name        blank: false, unique: true
        reward      blank: false
        description blank: false
        type        blank: false, inList: ['foo', 'bar']
        amount      min: 0.0
        term        blank: false, inList: ['1 month', '2 months', '3 months' ]
    }

}