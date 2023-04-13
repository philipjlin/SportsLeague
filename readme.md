# Sports League


## Repository
<https://github.com/philipjlin/SportsLeague>


## Description
This project is an application that simulates a basketball season and displays
the results and statistics of the players and teams.

A schedule where each team will play every other team in the league in a home and away series round robin results in the season.

The results of each game are recorded and compiled at the end of the season so that relevant results can be displayed for each team. These results include wins, losses, winning percentage, home record, away record, last 10 record, and winning streak.

The results are displayed in a typical standings table found in any sport, and the standings can be for the entire league, or broken down into conferences.

Similarly, individual player stats for each player on a team will be recorded for each game, so that the stats for each game can be displayed on a player page. Stats for each player can be cumulated into season total or season average, and based on these stats, a leaderboard can be created with leaders in specific categories including points, assists, rebounds, and steals.


## Technologies
Development in Groovy using the Grails framework.
Spring Framework used for user authorization/authentication operations.


## High Level Components
* Season standings page with display options
* Individual statistics page with display options
* Team statistics page with display options
* Services that are used to run simulations
* User profile capability for saving and loading saved simulations


## Class Overview
Domain Objects

    - Conference - represents a conference in a league containing a number of teams.

    - Game - represents a single game played between two teams, with fields to keep track of home and away teams, points scored by each team, and the winner.

    - GameStats - represents a stat sheet containing stats for individual players for a specific game they played in.

    - League - represents the entire league of teams.

    - Person - represents an individual player on a team in the league. Has a list of GameStats objects that can be displayed in a game log, or as season total or season averages.

    - Season - represents a single season played in the league, with a start date and end date.

    - Team - represents a single team taking part in a season, with fields to keep track of the team roster, the team schedule against other teams, as well as the team's record in home and away games.


Controllers

    - ConferenceController - Controller with CRUD methods for Conference objects.

    - GameController - Controller with CRUD methods for Game objects.

    - GameStatsController - Controller with CRUD methods for GameStats objects.

    - LeagueController - Controller with CRUD methods for League objects.

    - PersonController - Controller with CRUD methods for Person objects, containing methods to return individual stats of a player who has played on a team in a season.

    - SeasonController - Controller with CRUD methods for Season objects, containing methods used to simulate a season and render the results at the end.

    - TeamController - Controller with CRUD methods for Team objects.


Services

    - GameService - Service containing the logic methods used in simulating games between teams.

    - GameStatsService - Service containing methods used to accumulate game stats for individual players.

    - SeasonService - Service containing the method used to simulate an entire season for a league.

Taglibs

    - GameStatsTagLib - used to help render views of total and average stats of a player by rendering player season stats to a table using the seasonStatsTable template.

Plugins

    - BioProfile - This plugin further defines users, with usernames and passwords used for authentication and roles used for authorization in the application.


## Views
Conference

    - create
    - edit
    - index
    - show

Game

    - create
    - edit
    - index
    - show

GameStats

    - create
    - edit
    - index
    - show

League

    - leaderboard (template)
    - create
    - edit
    - index
    - leaderboard
    - show

Person

    - gameStatsTable (template)
    - seasonStatsTable(template)
    - create
    - edit
    - show
    - index
    - stats

Season

    - standingsTable (template)
    - create
    - edit
    - index
    - show
    - showStandings

Team

    - create
    - edit
    - index
    - show
