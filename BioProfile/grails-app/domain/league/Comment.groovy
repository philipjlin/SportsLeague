package league

class Comment {

    String text
    Date dateCreated

    boolean approved

    def replies = []

    static belongsTo = [blogEntry:BlogEntry]

    static constraints = {
    }
}