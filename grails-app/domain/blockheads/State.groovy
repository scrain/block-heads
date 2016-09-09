package blockheads


import grails.rest.*
import groovy.transform.Sortable

@Sortable(includes=['name'])
@Resource(readOnly = false, formats = ['json', 'xml'])
class State {
    String name

    static constraints = {
        name blank: false
    }
}