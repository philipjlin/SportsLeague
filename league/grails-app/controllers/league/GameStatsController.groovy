package league


import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('permitAll')
class GameStatsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond GameStats.list(params), model: [gameStatsInstanceCount: GameStats.count()]
    }

    def show(GameStats gameStatsInstance) {
        respond gameStatsInstance
    }

    def create() {
        respond new GameStats(params)
    }

    @Transactional
    def save(GameStats gameStatsInstance) {
        if (gameStatsInstance == null) {
            notFound()
            return
        }

        if (gameStatsInstance.hasErrors()) {
            respond gameStatsInstance.errors, view:'create'
            return
        }

        gameStatsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'gameStats.label', default: 'GameStats'), gameStatsInstance.id])
                redirect gameStatsInstance
            }
            '*' { respond gameStatsInstance, [status: CREATED] }
        }
    }

    def edit(GameStats gameStatsInstance) {
        respond gameStatsInstance
    }

    @Transactional
    def update(GameStats gameStatsInstance) {
        if (gameStatsInstance == null) {
            notFound()
            return
        }

        if (gameStatsInstance.hasErrors()) {
            respond gameStatsInstance.errors, view:'edit'
            return
        }

        gameStatsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'GameStats.label', default: 'GameStats'), gameStatsInstance.id])
                redirect gameStatsInstance
            }
            '*'{ respond gameStatsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(GameStats gameStatsInstance) {

        if (gameStatsInstance == null) {
            notFound()
            return
        }

        gameStatsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'GameStats.label', default: 'GameStats'), gameStatsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'gameStats.label', default: 'GameStats'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
