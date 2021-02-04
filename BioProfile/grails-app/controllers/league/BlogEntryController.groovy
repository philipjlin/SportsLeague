package league

import org.springframework.security.access.annotation.Secured
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured("permitAll")
class BlogEntryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def springSecurityService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond BlogEntry.list(params), model:[blogEntryCount: BlogEntry.count()]
    }

    /*
     *
     * Adds an approved comment to a blog entry
     *
     */
    @Secured("ROLE_USER")
    def addCommentToBlogEntry() {

        def blogEntry = BlogEntry.get(params.entryId)

        def commentToAdd = new Comment(text:params.text, dateCreated:new Date(), blogEntry:blogEntry, approved:true)
        commentToAdd.save(failOnError:true)

        blogEntry.comments.add(commentToAdd)

        blogEntry.save(failOnError:true)

        render view:'show', model:[blogEntry:blogEntry]
    }

    /*
     *
     * Adds a published blog entry to user's blogentries list
     *
     */
    @Secured("ROLE_USER")
    def addPublishedEntry() {

        def user = User.get(springSecurityService.principal.id)

        def blogEntry = new BlogEntry(text:params.text, dateCreated:new Date(), datePublished:new Date(), published:true, user:user, comments:[])

        blogEntry.save(flush:true, failOnError:true)

        user.blogEntries.add(blogEntry)
        user.save(flush:true, failOnError:true)

        render view:'show', model:[blogEntry:blogEntry]
    }

    /*
     *
     * Adds an unpublished blog entry to user's blogentries list
     *
     */
    @Secured("ROLE_USER")
    def addUnpublishedEntry() {

        def user = User.get(springSecurityService.principal.id)

        def blogEntry = new BlogEntry(text:params.text, dateCreated:new Date(), datePublished:new Date(), published:false, user:user, comments:[])

        blogEntry.save(flush:true, failOnError:true)

        user.blogEntries.add(blogEntry)
        user.save(flush:true, failOnError:true)

        render view:'show', model:[blogEntry:blogEntry]
    }


    /*
     *
     * Adds an unapproved reply to a comment on a blog entry
     *
     */
    @Secured("ROLE_USER")
    def addReplyToComment() {

        def comment = Comment.get(params.commentId)

        def replyToAdd = new Comment(text:params.text, dateCreated:new Date(), blogEntry:comment.blogEntry, approved:false)
        replyToAdd.save(failOnError:true)

        comment.replies.add(replyToAdd)

        comment.save(failOnError:true)

        render view:'show', model:[blogEntry:comment.blogEntry]
    }



    def show(BlogEntry blogEntry) {
        respond blogEntry
    }

    def create() {
        respond new BlogEntry(params)
    }

    @Transactional
    def save(BlogEntry blogEntry) {
        if (blogEntry == null) {
            notFound()
            return
        }

        if (blogEntry.hasErrors()) {
            respond blogEntry.errors, view:'create'
            return
        }

        blogEntry.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'blogEntry.label', default: 'BlogEntry'), blogEntry.id])
                redirect blogEntry
            }
            '*' { respond blogEntry, [status: CREATED] }
        }
    }

    def edit(BlogEntry blogEntry) {
        respond blogEntry
    }

    @Transactional
    def update(BlogEntry blogEntry) {
        if (blogEntry == null) {
            notFound()
            return
        }

        if (blogEntry.hasErrors()) {
            respond blogEntry.errors, view:'edit'
            return
        }

        blogEntry.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'BlogEntry.label', default: 'BlogEntry'), blogEntry.id])
                redirect blogEntry
            }
            '*'{ respond blogEntry, [status: OK] }
        }
    }

    @Transactional
    def delete(BlogEntry blogEntry) {

        if (blogEntry == null) {
            notFound()
            return
        }

        blogEntry.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'BlogEntry.label', default: 'BlogEntry'), blogEntry.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'blogEntry.label', default: 'BlogEntry'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
