package league

import league.Conference
import league.League
import league.Person
import league.Season
import league.Team
import grails.test.spock.IntegrationSpec

class SeasonServiceIntegrationSpec extends IntegrationSpec {

    def seasonService

    def setup() {
    }

    def cleanup() {
    }

    void "test simulateSeason returns resultsMap with results for each team"() {

        when:

        def curry = new Person(firstName:"Stephen", lastName:"Curry", role:"Guard", bio:'For Three.', height:'6\'3\"', weight:'190', birthDate:Date.parse("MM-dd-yyyy", "03-14-1988"), birthPlace:'Akron, OH', universityAttended:'Davidson')
        def leonard = new Person(firstName:"Kawhi", lastName:"Leonard", role:"Forward", bio:'Silent Assasin.', height:'6\'7\"', weight:'230', birthDate:Date.parse("MM-dd-yyyy", "06-29-1991"), birthPlace:'Los Angeles, CA', universityAttended:'San Diego State')
        def durant = new Person(firstName:"Kevin", lastName:"Durant", role:"Forward", bio:'Oden Who?', height:'6\'9\"', weight:'240', birthDate:Date.parse("MM-dd-yyyy", "09-29-1988"), birthPlace:'Washington, DC', universityAttended:'Texas')
        def paul = new Person(firstName:"Chris", lastName:"Paul", role:"Guard", bio:'Gets Assists.', height:'6\'0\"', weight:'175', birthDate:Date.parse("MM-dd-yyyy", "05-06-1985"), birthPlace:'Winston-Salem, NC', universityAttended:'Wake Forest')
        def james = new Person(firstName:"Lebron", lastName:"James", role:"Forward", bio:'The King.', height:'6\'8\"', weight:'250', birthDate:Date.parse("MM-dd-yyyy", "12-30-1984"), birthPlace:'Akron, OH', universityAttended:'None')
        def lowry = new Person(firstName:"Kyle", lastName:"Lowry", role:"Guard", bio:'Attack Dog.', height:'6\'0\"', weight:'205', birthDate:Date.parse("MM-dd-yyyy", "03-25-1986"), birthPlace:'Philadelphia, PA', universityAttended:'Villanova')
        def thomas = new Person(firstName:"Isaiah", lastName:"Thomas", role:"Guard", bio:'How Tall?', height:'5\'9\"', weight:'185', birthDate:Date.parse("MM-dd-yyyy", "02-07-1989"), birthPlace:'Tacoma, WA', universityAttended:'Washington')
        def millsap = new Person(firstName:"Paul", lastName:"Millsap", role:"Forward", bio:'Thief Chief', height:'6\'8\"', weight:'245', birthDate:Date.parse("MM-dd-yyyy", "02-10-1985"), birthPlace:'Monroe, LA', universityAttended:'LA Tech')

        curry.gameStatsLog = []
        leonard.gameStatsLog = []
        durant.gameStatsLog = []
        paul.gameStatsLog = []
        james.gameStatsLog = []
        lowry.gameStatsLog = []
        thomas.gameStatsLog = []
        millsap.gameStatsLog = []

        def warriors = new Team(teamName:"Warriors", location:"Oracle Arena", conferenceName:"Western Conference")
        def spurs = new Team(teamName:"Spurs", location:"AT&T Center", conferenceName:"Western Conference")
        def thunder = new Team(teamName:"Thunder", location:"Chsp. Energy Arena", conferenceName:"Western Conference")
        def clippers = new Team(teamName:"Clippers", location:"Staples Center", conferenceName:"Western Conference")
        def cavaliers = new Team(teamName:"Cavaliers", location:"Quicken Loans Arena", conferenceName:"Eastern Conference")
        def raptors = new Team(teamName:"Raptors", location:"Air Canada Centre", conferenceName:"Eastern Conference")
        def celtics = new Team(teamName:"Celtics", location:"TD Garden", conferenceName:"Eastern Conference")
        def hawks = new Team(teamName:"Hawks", location:"Philips Arena", conferenceName:"Eastern Conference")

        warriors.addToPersons(curry)
        warriors.save(failOnError:true)
        spurs.addToPersons(leonard)
        spurs.save(failOnError:true)
        thunder.addToPersons(durant)
        thunder.save(failOnError:true)
        clippers.addToPersons(paul)
        clippers.save(failOnError:true)
        cavaliers.addToPersons(james)
        cavaliers.save(failOnError:true)
        raptors.addToPersons(lowry)
        raptors.save(failOnError:true)
        celtics.addToPersons(thomas)
        celtics.save(failOnError:true)
        hawks.addToPersons(millsap)
        hawks.save(failOnError:true)

        def westernConference = new Conference(conferenceName:"Western")
        def easternConference = new Conference(conferenceName:"Eastern")
        westernConference.addToTeams(warriors)
        westernConference.addToTeams(spurs)
        westernConference.addToTeams(thunder)
        westernConference.addToTeams(clippers)
        easternConference.addToTeams(cavaliers)
        easternConference.addToTeams(raptors)
        easternConference.addToTeams(celtics)
        easternConference.addToTeams(hawks)
        westernConference.save(failOnError:true)
        easternConference.save(failOnError:true)

        def league = new League(leagueName:"Test League", leagueSize:8)
        league.addToConferences(westernConference)
        league.addToConferences(easternConference)
        league.save(failOnError:true)

        def season1 = new Season(seasonName:"2014-2015 Season", seasonStart:(Date.parse('MM-dd-yyyy','09-01-2015')), seasonEnd:(Date.parse('MM-dd-yyyy','04-30-2016')), league:league )
        season1.save(failOnError:true)

        curry.currentSeason = season1
        leonard.currentSeason = season1
        durant.currentSeason = season1
        paul.currentSeason = season1
        james.currentSeason = season1
        lowry.currentSeason = season1
        thomas.currentSeason = season1
        millsap.currentSeason = season1

        then:
            print(season1)
            seasonService.simulateSeason(season1).size() == 8

    }
}
