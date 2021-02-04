package league

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Game)
class GameSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test homeTeam not null"() {

        when:
            def game = new Game(date:new Date(), time:'7:00PM', location:'New York',
                                homeTeam:new Team(), awayTeam:new Team(),
                                homePoints:90, awayPoints:88)
        then:
            !game.validate()
    }

    void "test awayTeam not null"() {

        when:
            def game = new Game(date:new Date(), time:'7:00PM', location:'New York',
                                homeTeam:new Team(), awayTeam:new Team(),
                                homePoints:90, awayPoints:88)
        then:
            !game.validate()
    }

    void "test date valid"() {

        when:
            def game = new Game(date:new Date(), time:'7:00PM', location:'New York',
                                homeTeam:new Team(), awayTeam:new Team(),
                                homePoints:90, awayPoints:88)
        then:
            !game.validate()
    }

    void "test date invalid"() {

        when:
            def game = new Game(date:(Date.parse('MM-dd-yyyy','03-21-2017')), time:'7:00PM', location:'New York',
                                homeTeam:new Team(), awayTeam:new Team(),
                                homePoints:90, awayPoints:88)
        then:
            !game.validate()
    }

    void "test time not null"() {

        when:
            def game = new Game(date:new Date(), time:'7:00PM', location:'New York',
                                homeTeam:new Team(), awayTeam:new Team(),
                                homePoints:90, awayPoints:88)
        then:
            !game.validate()
    }

    void "test location not null"() {

        when:
            def game = new Game(date:new Date(), time:'7:00PM', location:'New York',
                                homeTeam:new Team(), awayTeam:new Team(),
                                homePoints:90, awayPoints:88)
        then:
            !game.validate()
    }

    void "test homePoints not negative"() {

        when:
            def game = new Game(date:new Date(), time:'7:00PM', location:'New York',
                                homeTeam:new Team(), awayTeam:new Team(),
                                homePoints:90, awayPoints:88)
        then:
            !game.validate()
        when:
            game.homePoints < 0
        then:
            !game.validate()
    }

    void "test awayPoints not negative"() {

        when:
        def game = new Game(date: new Date(), time: '7:00PM', location: 'New York',
                homeTeam: new Team(), awayTeam: new Team(),
                homePoints: 90, awayPoints: 88)
        then:
        !game.validate()
        when:
        game.awayPoints < 0
        then:
        !game.validate()
    }

}
