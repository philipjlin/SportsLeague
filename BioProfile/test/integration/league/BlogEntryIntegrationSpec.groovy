package league

import grails.test.mixin.Mock
import grails.test.spock.IntegrationSpec

@Mock([BlogEntry, BlogEntryController, Role, UserRole])
class BlogEntryIntegrationSpec extends IntegrationSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test comment added to existing blog entry"() {

        when:
            def blogEntry = new BlogEntry(text:"First entry.", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:true, comments:[], user:new User())
            def comment = new Comment(text:"Comment text.", dateCreated:new Date(), blogEntry:new BlogEntry(), approved:true)

            blogEntry.comments.add(comment)

        then:
            blogEntry.comments.size() == 1
    }

    void "test blog entry saved"(){

        when:
            Role user = new Role('ROLE_USER')
            user.save(failOnError:true)

            User user1 = new User(username:'user1', password:'password', bio:"User #1.", birthDate:Date.parse("MM-dd-yyyy", "02-30-1978"), birthPlace:"Austin", height:'6\'0\"', weight:'180', universityAttended:'Columbia', blogEntries:[], enabled:true)
            user1.save(failOnError:true)

            UserRole.create(user1, user).save(flush:true, failOnError:true)

            BlogEntry user1_entry1 = new BlogEntry(text:"First entry from user1", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:false, comments:[], user:user1)
            user1_entry1.save(failOnError:true)

            user1.blogEntries.add(user1_entry1)
            user1.save(failOnError:true)

        then:
            user1.blogEntries.size() == 1
            user1.blogEntries[0].published == false
    }

    void "test blog entry published"(){

        when:
            Role user = new Role('ROLE_USER')
            user.save(failOnError:true)

            User user1 = new User(username:'user1', password:'password', bio:"User #1.", birthDate:Date.parse("MM-dd-yyyy", "02-30-1978"), birthPlace:"Austin", height:'6\'0\"', weight:'180', universityAttended:'Columbia', blogEntries:[], enabled:true)
            user1.save(failOnError:true)

            UserRole.create(user1, user).save(flush:true, failOnError:true)

            BlogEntry user1_entry1 = new BlogEntry(text:"First entry from user1", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:true, comments:[], user:user1)
            user1_entry1.save(failOnError:true)

            user1.blogEntries.add(user1_entry1)
            user1.save(failOnError:true)

        then:
            user1.blogEntries.size() == 1
            user1.blogEntries[0].published == true
    }

    void "test reply posted to comment"(){

        when:
            def blogEntry = new BlogEntry(text:"First entry.", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:true, comments:[], user:new User())
            def comment = new Comment(text:"Comment text.", dateCreated:new Date(), blogEntry:new BlogEntry(), approved:true, replies:[])
            def reply = new Comment(text:"Reply text.", dateCreated:new Date(), blogEntry:new BlogEntry(), approved:true)

            blogEntry.comments.add(comment)

            blogEntry.comments[0].replies.add(reply)

        then:
            blogEntry.comments[0].replies.size() == 1
    }
}
