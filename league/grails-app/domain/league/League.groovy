package league

class League {

    String leagueName
    int leagueSize

    static hasMany=[conferences:Conference]

    static constraints = {

        leagueName blank:false, unique:true
        leagueSize blank:false, min:0
    }
}
