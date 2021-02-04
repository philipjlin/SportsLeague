package league

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test firstName not null"() {

        when:
            def person = new Person(firstName:'Kobe', lastName:'Bryant', role:'Small Forward', bio:'This is the bio.',
                                    birthPlace:'Philadelphia', height:'6\'9\"', universityAttended:'NA')
        then:
            !person.validate()
    }

    void "test lastName not null"() {

        when:
            def person = new Person(firstName:'Kobe', lastName:'Bryant', role:'Small Forward', bio:'This is the bio.',
                                    birthPlace:'Philadelphia', height:'6\'9\"', universityAttended:'NA')
        then:
            !person.validate()
    }

    void "test role not null"() {

        when:
            def person = new Person(firstName:'Kobe', lastName:'Bryant', role:'Small Forward', bio:'This is the bio.',
                                    birthPlace:'Philadelphia', height:'6\'9\"', universityAttended:'NA')
        then:
            !person.validate()

    }

    void "test height not null"() {

        when:
        def person = new Person(firstName:'Kobe', lastName:'Bryant', role:'Small Forward', bio:'This is the bio.',
                birthPlace:'Philadelphia', birthDate:'1/15/1980', height:'6\'9\"', weight:'185 lbs', universityAttended:'NA')
        then:
        !person.validate()
    }

    void "test universityAttended not null"() {

        when:
        def person = new Person(firstName:'Kobe', lastName:'Bryant', role:'Small Forward', bio:'This is the bio.',
                birthPlace:'Philadelphia', birthDate:'1/15/1980', height:'6\'9\"', weight:'185 lbs', universityAttended:'NA')
        then:
        !person.validate()

    }


}
