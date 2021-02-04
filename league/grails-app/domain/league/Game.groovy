package league

class Game {

    Date date
    String time
    String location

    Team homeTeam
    Team awayTeam
    int homePoints
    int awayPoints

    Team winner

    static hasMany=[teams:Team, gameStats:GameStats]

    static constraints = {
    }
}
