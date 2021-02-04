package league

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Season)
class SeasonSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test seasonName not null"() {

        when:
            def season = new Season(seasonName:'2015-2016 Season',
                                    seasonStart:(Date.parse('MM-dd-yyyy','09-01-2015')),
                                    seasonEnd:(Date.parse('MM-dd-yyyy','04-30-2016')))
        then:
            !season.validate()
    }

    void "test seasonStart date valid"() {

        when:
            def season = new Season(seasonName:'2015-2016 Season',
                                    seasonStart:(Date.parse('MM-dd-yyyy','09-01-2015')),
                                    seasonEnd:(Date.parse('MM-dd-yyyy','04-30-2016')))
        then:
            !season.validate()
    }

    void "test seasonStart date invalid"() {

        when:
            def season = new Season(seasonName:'2015-2016 Season',
                                    seasonStart:(Date.parse('MM-dd-yyyy','03-21-2017')),
                                    seasonEnd:(Date.parse('MM-dd-yyyy','04-30-2016')))
        then:
            !season.validate()

    }

    void "test seasonEnd date valid and later than seasonStart date"() {

        when:
            def season = new Season(seasonName:'2015-2016 Season',
                                    seasonStart:(Date.parse('MM-dd-yyyy','09-01-2015')),
                                    seasonEnd:(Date.parse('MM-dd-yyyy','04-30-2016')))
        then:
            !season.validate()
    }
    
}
