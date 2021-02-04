package league

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(League)
class LeagueSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test leagueName not null"() {

        when:
            def league = new League(leagueName:'The Association', leagueSize:32)
        then:
            league.validate()
        when:
            league.leagueName = null
        then:
            !league.validate()
    }

    void "test leagueSize greater than 1"() {

        when:
            def league = new League(leagueName:'The Association', leagueSize:32)
        then:
            league.validate()
        when:
            league.leagueSize < 2
        then:
            league.validate()
    }
}
