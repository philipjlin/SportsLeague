package league

class Person {

    String firstName
    String lastName
    String role

    String bio
    String birthPlace
    Date birthDate
    String height
    String weight
    String universityAttended

    User user

    Season currentSeason

    static belongsTo = [team:Team]
    static hasMany = [gameStatsLog:GameStats]

    static constraints = {

        firstName blank:false
        lastName blank:false
        role blank:false

        user nullable:true
        currentSeason nullable:true
        gameStatsLog nullable:true
        bio nullable:true
        birthPlace nullable:true
        birthDate nullable:true
        height nullable:true
        weight nullable:true
        universityAttended nullable:true
    }
}
