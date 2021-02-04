package league

import grails.transaction.Transactional

@Transactional
class SeasonService {

    GameService gameService

    /*
     *
     * Simulates all games played in an entire season
     * Populates Season object with data
     *
     */
    def simulateSeason(Season seasonInstance){

        //Define and populate a list of the teams in the league
        def teamsList = []

        seasonInstance.league.conferences.each{ conference ->

            conference.teams.each{ team ->

                teamsList.add(team)
            }
        }

        //Simulate all home and away games. (n/2)(n-1) games total
        //Figure out how to implement algorithm automatically
        //Week 1:
        gameService.simulateGame(teamsList.get(0), teamsList.get(7))
        gameService.simulateGame(teamsList.get(1), teamsList.get(6))
        gameService.simulateGame(teamsList.get(2), teamsList.get(5))
        gameService.simulateGame(teamsList.get(3), teamsList.get(4))
        //Week 2:
        gameService.simulateGame(teamsList.get(0), teamsList.get(6))
        gameService.simulateGame(teamsList.get(7), teamsList.get(5))
        gameService.simulateGame(teamsList.get(1), teamsList.get(4))
        gameService.simulateGame(teamsList.get(2), teamsList.get(3))
        //Week 3:
        gameService.simulateGame(teamsList.get(0), teamsList.get(5))
        gameService.simulateGame(teamsList.get(6), teamsList.get(4))
        gameService.simulateGame(teamsList.get(7), teamsList.get(3))
        gameService.simulateGame(teamsList.get(1), teamsList.get(2))
        //Week 4:
        gameService.simulateGame(teamsList.get(0), teamsList.get(4))
        gameService.simulateGame(teamsList.get(5), teamsList.get(3))
        gameService.simulateGame(teamsList.get(6), teamsList.get(2))
        gameService.simulateGame(teamsList.get(7), teamsList.get(1))
        //Week 5:
        gameService.simulateGame(teamsList.get(0), teamsList.get(3))
        gameService.simulateGame(teamsList.get(4), teamsList.get(2))
        gameService.simulateGame(teamsList.get(5), teamsList.get(1))
        gameService.simulateGame(teamsList.get(6), teamsList.get(7))
        //Week 6:
        gameService.simulateGame(teamsList.get(0), teamsList.get(2))
        gameService.simulateGame(teamsList.get(3), teamsList.get(1))
        gameService.simulateGame(teamsList.get(4), teamsList.get(7))
        gameService.simulateGame(teamsList.get(5), teamsList.get(6))
        //Week 7:
        gameService.simulateGame(teamsList.get(0), teamsList.get(1))
        gameService.simulateGame(teamsList.get(2), teamsList.get(7))
        gameService.simulateGame(teamsList.get(3), teamsList.get(6))
        gameService.simulateGame(teamsList.get(4), teamsList.get(5))
        //Week 8:
        gameService.simulateGame(teamsList.get(7), teamsList.get(0))
        gameService.simulateGame(teamsList.get(6), teamsList.get(1))
        gameService.simulateGame(teamsList.get(5), teamsList.get(2))
        gameService.simulateGame(teamsList.get(4), teamsList.get(3))
        //Week 9:
        gameService.simulateGame(teamsList.get(6), teamsList.get(0))
        gameService.simulateGame(teamsList.get(5), teamsList.get(7))
        gameService.simulateGame(teamsList.get(4), teamsList.get(1))
        gameService.simulateGame(teamsList.get(3), teamsList.get(2))
        //Week 10:
        gameService.simulateGame(teamsList.get(5), teamsList.get(0))
        gameService.simulateGame(teamsList.get(4), teamsList.get(6))
        gameService.simulateGame(teamsList.get(3), teamsList.get(7))
        gameService.simulateGame(teamsList.get(2), teamsList.get(1))
        //Week 11:
        gameService.simulateGame(teamsList.get(4), teamsList.get(0))
        gameService.simulateGame(teamsList.get(3), teamsList.get(5))
        gameService.simulateGame(teamsList.get(2), teamsList.get(6))
        gameService.simulateGame(teamsList.get(1), teamsList.get(7))
        //Week 12:
        gameService.simulateGame(teamsList.get(3), teamsList.get(0))
        gameService.simulateGame(teamsList.get(2), teamsList.get(4))
        gameService.simulateGame(teamsList.get(1), teamsList.get(5))
        gameService.simulateGame(teamsList.get(7), teamsList.get(6))
        //Week 13:
        gameService.simulateGame(teamsList.get(2), teamsList.get(0))
        gameService.simulateGame(teamsList.get(1), teamsList.get(3))
        gameService.simulateGame(teamsList.get(7), teamsList.get(4))
        gameService.simulateGame(teamsList.get(6), teamsList.get(5))
        //Week 14:
        gameService.simulateGame(teamsList.get(1), teamsList.get(0))
        gameService.simulateGame(teamsList.get(7), teamsList.get(2))
        gameService.simulateGame(teamsList.get(6), teamsList.get(3))
        gameService.simulateGame(teamsList.get(5), teamsList.get(4))


        //The list of teams now each have a completed schedule

        //Define a list with W L % HR RR L10 STK to put in the resultsMap, from which the view will get stuff to print
        def resultsMap = [:]
        teamsList.each{ team ->

            resultsMap.put( team, [] )
        }


        def totalWins = []
        def totalLosses = []
        def percentages = []
        def homeRecords = []
        def roadRecords = []
        def last10s = []
        def streaks = []

        //Calculate Total Wins for each team
        teamsList.each{ team ->

            def wins = team.homeWins + team.roadWins
            totalWins.add(wins)

            def losses = team.homeLosses + team.roadLosses
            totalLosses.add(losses)


            if( losses != 0 ){

                percentages.add( (100*((double)wins/(wins + losses))).round(1) )
            }
            else{

                percentages.add( 100.0 )
            }

            homeRecords.add( "$team.homeWins" + "-" + "$team.homeLosses" )
            roadRecords.add( "$team.roadWins" + "-" + "$team.roadLosses" )
        }


        //Calculate Streaks for each team
        teamsList.each{ team ->

            def index = 0
            def count = 0
            def reversedGames = team.schedule.reverse()

            while ( (reversedGames.get(index).winner).equals(team) ) {

                index++
                count++
            }

            streaks.add(count)
        }

        //Calculate L10 Records for each team
        teamsList.each{ team ->

            def l10wins = 0
            def l10losses = 0
            def reversedGames = team.schedule.reverse()

            for ( int i=0 ; i<10 ; i++ ) {

                if( reversedGames[i].winner.equals(team) ){

                    l10wins++
                }
                else{

                    l10losses++
                }
            }

            def l10Record = "$l10wins" + "-" + "$l10losses"

            last10s.add(l10Record)
        }

        //Add Statistics To Each Team's Results List
        def index = 0
        resultsMap.each{ entry ->

            (entry.value).add( totalWins[index] )
            (entry.value).add( totalLosses[index] )
            (entry.value).add( percentages[index] )
            (entry.value).add( homeRecords[index] )
            (entry.value).add( roadRecords[index] )
            (entry.value).add( last10s[index] )
            (entry.value).add( streaks[index] )

            index++
        }

        return resultsMap
    }

}
