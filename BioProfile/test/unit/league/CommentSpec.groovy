package league

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
class CommentSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test text not null"() {

        when:
        def comment = new Comment(text:"Comment text.", dateCreated:new Date(), blogEntry:new BlogEntry(), approved:false)

        then:
        comment.validate()
    }

    void "test dateCreated not null"() {

        when:
        def comment = new Comment(text:"Comment text.", dateCreated:new Date(), blogEntry:new BlogEntry(), approved:false)

        then:
        comment.validate()
    }

    void "test comment has blogEntry"() {

        when:
        def comment = new Comment(text:"Comment text.", dateCreated:new Date(), blogEntry:new BlogEntry(), approved:false)

        then:
        comment.validate()
    }

    void "comment is unapproved"() {

        when:
        def comment = new Comment(text:"Comment text.", dateCreated:new Date(), blogEntry:new BlogEntry(), approved:false)

        then:
        comment.approved == false
        comment.validate()
    }

    void "comment is approved"() {

        when:
        def comment = new Comment(text:"Comment text.", dateCreated:new Date(), blogEntry:new BlogEntry(), approved:true)

        then:
        comment.approved == true
        comment.validate()
    }
}
