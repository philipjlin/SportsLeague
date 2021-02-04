package league

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@Mock([BlogEntry])
class BlogEntrySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test text not null"() {

        when:
        def blogEntry = new BlogEntry(text:"First entry.", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:true, comments:[], user:new User())

        then:
        blogEntry.validate()
    }

    void "test dateCreated not null"() {

        when:
        def blogEntry = new BlogEntry(text:"First entry.", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:true, comments:[], user:new User())

        then:
        blogEntry.validate()
    }

    void "test datePublished not null"() {

        when:
        def blogEntry = new BlogEntry(text:"First entry.", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:true, comments:[], user:new User())

        then:
        blogEntry.validate()
    }

    void "test published is true"() {

        when:
        def blogEntry = new BlogEntry(text:"First entry.", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:true, comments:[], user:new User())

        then:
        blogEntry.validate()
    }

    void "test published is false"() {

        when:
        def blogEntry = new BlogEntry(text:"First entry.", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:false, comments:[], user:new User())

        then:
        blogEntry.validate()
    }

    void "test blogEntry has User"() {

        when:
        def blogEntry = new BlogEntry(text:"First entry.", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:false, comments:[], user:new User())

        then:
        blogEntry.validate()
    }


}
