package league

//the statistics for the individual players from each team involved in each game
class GameStats {

    int minutesPlayed
    int points
    int assists
    int rebounds
    int steals
    int blocks
    int shotsAttempted
    int shotsMade
    double shotsPercentage
    int threesAttempted
    int threesMade
    double threesPercentage
    int personalFouls

    static belongsTo = [game:Game, player:Person]

    static constraints = {

        minutesPlayed nullable:true, min:0
        points nullable:true, min:0
        assists nullable:true, min:0
        rebounds nullable:true, min:0
        steals nullable:true, min:0
        blocks nullable:true, min:0
        shotsAttempted nullable:true, min:0
        shotsMade nullable:true, min:0
        shotsPercentage nullable:true, min:0d
        threesAttempted nullable:true, min:0
        threesMade nullable:true, min:0
        threesPercentage nullable:true, min:0d
        personalFouls nullable:true, min:0
        game nullable:true
    }

    def shotsPercentage(){

        if( shotsAttempted != 0 )
            (100*((double)shotsMade)/((double)shotsAttempted)).round(1)
        else
            0
    }

    def threesPercentage(){
        if( threesAttempted != 0 )
            (100*((double)threesMade)/((double)threesAttempted)).round(1)
        else
            0
    }

}
