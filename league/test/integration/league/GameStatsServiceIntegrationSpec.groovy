package league

import league.Conference
import league.League
import league.Person
import league.Season
import league.Team
import grails.test.spock.IntegrationSpec

class GameStatsServiceIntegrationSpec extends IntegrationSpec {

    def gameStatsService

    def setup() {
    }

    def cleanup() {
    }

    void "test getPlayerMaps method fills stat maps"() {

        when:
            def hornets = new Team(teamName:"Charlotte Hornets", location:"Time Warner Cable Arena", conferenceName:"Eastern")
            def jazz = new Team(teamName:"Utah Jazz", location:"Vivint Smart Home Arena", conferenceName:"Western Conference")

            def walker = new Person(firstName:"Kemba", lastName:"Walker", role:"Guard", bio:'Player 1.', height:'6\'1\"', weight:'185', birthDate:Date.parse("MM-dd-yyyy", "05-08-1990"), birthPlace:'Bronx, NY', universityAttended:'Connecticut')
            def hayward = new Person(firstName:"Gordon", lastName:"Hayward", role:"Forward", bio:'Player 2.', height:'6\'8\"', weight:'225', birthDate:Date.parse("MM-dd-yyyy", "03-23-1990"), birthPlace:'Indianapolis, IN', universityAttended:'Butler')

            walker.gameStatsLog = []
            hayward.gameStatsLog = []
            jazz.addToPersons(hayward)
            jazz.save(failOnError:true)
            hornets.addToPersons(walker)
            hornets.save(failOnError:true)

            def west = new Conference(conferenceName:"West")
            def east = new Conference(conferenceName:"East")
            west.addToTeams(jazz)
            east.addToTeams(hornets)

            def league = new League(leagueName:"Test League", leagueSize:2)
            league.addToConferences(west)
            league.addToConferences(east)
            league.save(failOnError:true)

            def season1 = new Season(seasonName:"2000-2001 Season", seasonStart:(Date.parse('MM-dd-yyyy','09-01-2000')), seasonEnd:(Date.parse('MM-dd-yyyy','04-30-2001')), league:league )
            season1.save(failOnError:true)

            walker.currentSeason = season1
            hayward.currentSeason = season1

        then:
            gameStatsService.getPlayerMaps(season1).points.size() == 2
            gameStatsService.getPlayerMaps(season1).rebounds.size() == 2
            gameStatsService.getPlayerMaps(season1).assists.size() == 2
            gameStatsService.getPlayerMaps(season1).steals.size() == 2
            gameStatsService.getPlayerMaps(season1).blocks.size() == 2

    }
}
