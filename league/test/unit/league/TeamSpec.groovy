package league

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Team)
class TeamSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test teamName not null"() {

        when:
            Team team = new Team(teamName:'Knicks', location:'New York')
        then:
            !team.validate()
    }

    void "test location not null"() {

        when:
            Team team = new Team(teamName:'Knicks', location:'New York')
        then:
            !team.validate()
    }

}
