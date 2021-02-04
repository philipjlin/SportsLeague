package league

import grails.transaction.Transactional


/**
 * This service defines logic methods pertaining to simulated games played between teams
 */
@Transactional
class GameService {

    /*
     *
     *
     *
     * Simulates a game between two teams, adds game to each team's schedule
     *
     */
    def simulateGame(Team homeTeam, Team awayTeam){

        Game simmedGame = new Game(date:new Date(), time:"7.00PM", location:homeTeam.location, homeTeam:homeTeam, awayTeam:awayTeam)

        //Keep track of players playing in the game so individual stats can be tracked
        def playersInGame = []
        homeTeam.persons.each{ person ->

            if(person.role.equals("Guard") || person.role.equals("Forward") || person.role.equals("Center"))
                playersInGame.add(person)
        }
        awayTeam.persons.each{ person ->
            if(person.role.equals("Guard") || person.role.equals("Forward") || person.role.equals("Center"))
                playersInGame.add(person)
        }


        Random generator = new Random()
        def homePoints = 75 + generator.nextInt(50)
        def awayPoints = 70 + generator.nextInt(50)
        simmedGame.homePoints = homePoints
        simmedGame.awayPoints = awayPoints

        //Simulate the winner of the game
        if( homePoints > awayPoints ){

            simmedGame.winner = homeTeam
            homeTeam.homeWins++
            awayTeam.roadLosses++
        }
        else if( awayPoints > homePoints ){

            simmedGame.winner = awayTeam
            awayTeam.roadWins++
            homeTeam.homeLosses++
        }


        //Create and fill in a GameStats object for each person in the game
        GameStats currentGameStats = new GameStats()
        playersInGame.each{ person ->

            currentGameStats.game = simmedGame
            currentGameStats.minutesPlayed = 20 + generator.nextInt(20)
            currentGameStats.assists = generator.nextInt(15)
            currentGameStats.rebounds = generator.nextInt(20)
            currentGameStats.steals = generator.nextInt(5)
            currentGameStats.blocks = generator.nextInt(5)
            currentGameStats.shotsAttempted = generator.nextInt(25)
            if( currentGameStats.shotsAttempted != 0 ) {

                currentGameStats.shotsMade = generator.nextInt(currentGameStats.shotsAttempted)
                currentGameStats.shotsPercentage = (currentGameStats.shotsMade) / (currentGameStats.shotsAttempted)
            }
            currentGameStats.threesAttempted = generator.nextInt(10)
            if( currentGameStats.threesAttempted != 0 ){

                currentGameStats.threesMade = generator.nextInt(currentGameStats.threesAttempted)
                currentGameStats.threesPercentage = (currentGameStats.threesMade)/(currentGameStats.threesAttempted)
            }
            currentGameStats.personalFouls = generator.nextInt(6)
            currentGameStats.points = (2 * currentGameStats.shotsMade) + (3 * currentGameStats.threesMade)

            //Add the GameStats object to the player's game stats log (list).
            person.gameStatsLog.add(currentGameStats)
        }

        //Add game object to schedule of home and away teams
        homeTeam.schedule.add(simmedGame)
        awayTeam.schedule.add(simmedGame)
    }
}
