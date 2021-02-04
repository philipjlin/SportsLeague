package league

class Team {

    String teamName
    String location
    String conferenceName

    int homeWins
    int homeLosses
    int roadWins
    int roadLosses

    //List of games a team has played
    def schedule = []

    static belongsTo = Conference
    static hasMany = [persons:Person]

    static constraints = {

        teamName blank:false, unique:true
        location blank:false
        schedule nullable:true
    }
}
