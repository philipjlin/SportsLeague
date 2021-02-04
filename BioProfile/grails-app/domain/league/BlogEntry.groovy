package league

class BlogEntry {

    String text
    Date dateCreated
    Date datePublished
    boolean published

    static belongsTo = [user:User]
    static hasMany = [comments:Comment]

    static constraints = {
    }
}
