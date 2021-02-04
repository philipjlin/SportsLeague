import league.*

class BootStrap {

    def init = { servletContext ->


        Role admin = new Role('ROLE_ADMIN')
        Role user = new Role('ROLE_USER')
        admin.save(failOnError:true)
        user.save(failOnError:true)

        User user_admin = new User(username:'user_admin', password:'password', bio:"Administrator.", birthDate:Date.parse("MM-dd-yyyy", "01-14-1988"), birthPlace:"New York", height:'6\'3\"', weight:'190', universityAttended:'Stanford', blogEntries:[], enabled:true)
        User user1 = new User(username:'user1', password:'password', bio:"User #1.", birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), birthPlace:"Place", height:'6\'0\"', weight:'180', universityAttended:'University', blogEntries:[], enabled:true)
        User user2 = new User(username:'user2', password:'password', bio:"User #2.", birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), birthPlace:"Place", height:'6\'0\"', weight:'180', universityAttended:'University', blogEntries:[], enabled:true)
        User user3 = new User(username:'user3', password:'password', bio:"User #3.", birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), birthPlace:"Place", height:'6\'0\"', weight:'180', universityAttended:'University', blogEntries:[], enabled:true)
        User user4 = new User(username:'user4', password:'password', bio:"User #4.", birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), birthPlace:"Place", height:'6\'0\"', weight:'180', universityAttended:'University', blogEntries:[], enabled:true)
        User user5 = new User(username:'user5', password:'password', bio:"User #5.", birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), birthPlace:"Place", height:'6\'0\"', weight:'180', universityAttended:'University', blogEntries:[], enabled:true)
        User user6 = new User(username:'user6', password:'password', bio:"User #6.", birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), birthPlace:"Place", height:'6\'0\"', weight:'180', universityAttended:'University', blogEntries:[], enabled:true)
        User user7 = new User(username:'user7', password:'password', bio:"User #7.", birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), birthPlace:"Place", height:'6\'0\"', weight:'180', universityAttended:'University', blogEntries:[], enabled:true)
        User user8 = new User(username:'user8', password:'password', bio:"User #8.", birthDate:Date.parse("MM-dd-yyyy", "01-01-1900"), birthPlace:"Place", height:'6\'0\"', weight:'180', universityAttended:'University', blogEntries:[], enabled:true)


        user_admin.save(failOnError:true)
        user1.save(failOnError:true)
        user2.save(failOnError:true)
        user3.save(failOnError:true)
        user4.save(failOnError:true)
        user5.save(failOnError:true)
        user6.save(failOnError:true)
        user7.save(failOnError:true)
        user8.save(failOnError:true)


        UserRole.create(user_admin, admin).save(flush:true, failOnError:true)
        UserRole.create(user1, user).save(flush:true, failOnError:true)



        BlogEntry user1_entry1 = new BlogEntry(text:"First entry from user1", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-18-2016"), published:true, comments:[], user:user1)
        BlogEntry user1_entry2 = new BlogEntry(text:"Second entry from user1", dateCreated:Date.parse("MM-dd-yyyy", "04-15-2016"), datePublished:Date.parse("MM-dd-yyyy", "04-19-2016"), published:true, comments:[], user:user1)
        user1_entry1.save(failOnError:true)
        user1_entry2.save(failOnError:true)


        user1.blogEntries.add(user1_entry1)
        user1.blogEntries.add(user1_entry2)
        user1.save(failOnError:true)


        def curry = new Person(firstName:"Stephen", lastName:"Curry", role:"Guard", bio:'For Three.', height:'6\'3\"', weight:'190', birthDate:Date.parse("MM-dd-yyyy", "03-14-1988"), birthPlace:'Akron, OH', universityAttended:'Davidson', user:user1)
        def leonard = new Person(firstName:"Kawhi", lastName:"Leonard", role:"Forward", bio:'Silent Assasin.', height:'6\'7\"', weight:'230', birthDate:Date.parse("MM-dd-yyyy", "06-29-1991"), birthPlace:'Los Angeles, CA', universityAttended:'San Diego State', user:user2)
        def durant = new Person(firstName:"Kevin", lastName:"Durant", role:"Forward", bio:'Oden Who?', height:'6\'9\"', weight:'240', birthDate:Date.parse("MM-dd-yyyy", "09-29-1988"), birthPlace:'Washington, DC', universityAttended:'Texas', user:user3)
        def paul = new Person(firstName:"Chris", lastName:"Paul", role:"Guard", bio:'Gets Assists.', height:'6\'0\"', weight:'175', birthDate:Date.parse("MM-dd-yyyy", "05-06-1985"), birthPlace:'Winston-Salem, NC', universityAttended:'Wake Forest', user:user4)
        def james = new Person(firstName:"Lebron", lastName:"James", role:"Forward", bio:'The King.', height:'6\'8\"', weight:'250', birthDate:Date.parse("MM-dd-yyyy", "12-30-1984"), birthPlace:'Akron, OH', universityAttended:'None', user:user5)
        def lowry = new Person(firstName:"Kyle", lastName:"Lowry", role:"Guard", bio:'Attack Dog.', height:'6\'0\"', weight:'205', birthDate:Date.parse("MM-dd-yyyy", "03-25-1986"), birthPlace:'Philadelphia, PA', universityAttended:'Villanova', user:user6)
        def thomas = new Person(firstName:"Isaiah", lastName:"Thomas", role:"Guard", bio:'How Tall?', height:'5\'9\"', weight:'185', birthDate:Date.parse("MM-dd-yyyy", "02-07-1989"), birthPlace:'Tacoma, WA', universityAttended:'Washington', user:user7)
        def millsap = new Person(firstName:"Paul", lastName:"Millsap", role:"Forward", bio:'Thief Chief', height:'6\'8\"', weight:'245', birthDate:Date.parse("MM-dd-yyyy", "02-10-1985"), birthPlace:'Monroe, LA', universityAttended:'LA Tech', user:user8)

        def warriors = new Team(teamName:"Golden State Warriors", location:"Oracle Arena", conferenceName:"Western Conference")
        def spurs = new Team(teamName:"San Antonio Spurs", location:"AT&T Center", conferenceName:"Western Conference")
        def thunder = new Team(teamName:"Oklahoma City Thunder", location:"Chsp. Energy Arena", conferenceName:"Western Conference")
        def clippers = new Team(teamName:"Los Angeles Clippers", location:"Staples Center", conferenceName:"Western Conference")
        def cavaliers = new Team(teamName:"Cleveland Cavaliers", location:"Quicken Loans Arena", conferenceName:"Eastern Conference")
        def raptors = new Team(teamName:"Toronto Raptors", location:"Air Canada Centre", conferenceName:"Eastern Conference")
        def celtics = new Team(teamName:"Boston Celtics", location:"TD Garden", conferenceName:"Eastern Conference")
        def hawks = new Team(teamName:"Atlanta Hawks", location:"Philips Arena", conferenceName:"Eastern Conference")

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

        def westernConference = new Conference(conferenceName:"Western Conference")
        def easternConference = new Conference(conferenceName:"Eastern Conference")
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

        def league = new League(leagueName:"NBA", leagueSize:8)
        league.addToConferences(westernConference)
        league.addToConferences(easternConference)
        league.save(failOnError:true)

        def season1 = new Season(seasonName:"2015-2016 Season", seasonStart:(Date.parse('MM-dd-yyyy','09-01-2015')), seasonEnd:(Date.parse('MM-dd-yyyy','04-30-2016')), league:league )
        season1.save(failOnError:true)

        curry.currentSeason = season1
        leonard.currentSeason = season1
        durant.currentSeason = season1
        paul.currentSeason = season1
        james.currentSeason = season1
        lowry.currentSeason = season1
        thomas.currentSeason = season1
        millsap.currentSeason = season1

    }

    def destroy = {
    }
}
