package league

import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('permitAll')
class SeasonController {

    SeasonService seasonService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Season.list(params), model:[seasonInstanceCount: Season.count()]
    }


    //def simulateSeason(Season seasonInstance){} in SeasonService
    /*
     *
     *
     * Method to pass standings from simulated season to view
     *
     */
    def showStandings(Season seasonInstance){

        def resultsMap = seasonService.simulateSeason(seasonInstance)

        def eastResultsMap = [:]
        def westResultsMap = [:]

        resultsMap.each{ entry ->

            if( (entry.key).conferenceName.equals("Western Conference")){

                westResultsMap.put(entry.key, entry.value)
            }

            if( (entry.key).conferenceName.equals("Eastern Conference")){

                eastResultsMap.put(entry.key, entry.value)
            }
        }

        //Render to showStandings gsp view with results map, sorted by percentage (value at index 2 of resultsMap)
        render view:'showStandings', model:[results:resultsMap.sort{-it.value[2]}, westResults:westResultsMap.sort{-it.value[2]}, eastResults:eastResultsMap.sort{-it.value[2]}]
    }

    def show(Season seasonInstance) {
        respond seasonInstance
    }

    def create() {
        respond new Season(params)
    }

    @Transactional
    def save(Season seasonInstance) {
        if (seasonInstance == null) {
            notFound()
            return
        }

        if (seasonInstance.hasErrors()) {
            respond seasonInstance.errors, view:'create'
            return
        }

        seasonInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'season.label', default: 'Season'), seasonInstance.id])
                redirect seasonInstance
            }
            '*' { respond seasonInstance, [status: CREATED] }
        }
    }

    def edit(Season seasonInstance) {
        respond seasonInstance
    }

    @Transactional
    def update(Season seasonInstance) {
        if (seasonInstance == null) {
            notFound()
            return
        }

        if (seasonInstance.hasErrors()) {
            respond seasonInstance.errors, view:'edit'
            return
        }

        seasonInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Season.label', default: 'Season'), seasonInstance.id])
                redirect seasonInstance
            }
            '*'{ respond seasonInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Season seasonInstance) {

        if (seasonInstance == null) {
            notFound()
            return
        }

        seasonInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Season.label', default: 'Season'), seasonInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'season.label', default: 'Season'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

}
