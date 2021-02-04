package league

import grails.transaction.Transactional

@Transactional
class GameStatsService {

    /**
     *
     * Get all the players in a season, and return a map mapping players to list of per-game averages used in the leaderboard
     * Return a map [person:[PPG, APG, RPG, SPG]]
     */
    def static getPlayerMaps(Season seasonInstance) {

        //Add all the players in the league to a list
        def playersList = []
        seasonInstance.league.conferences.each{ conference ->

            conference.teams.each{ team ->

                team.persons.each{ person ->

                    if(person.role.equals("Guard") || person.role.equals("Forward") || person.role.equals("Center"))
                        playersList.add(person)
                }
            }
        }

        //Calculate PPG, APG, RPG, and SPG values for each player in the playerlist
        ////Define maps [Player:double]
        def playerPointsMap = [:]
        def playerAssistsMap = [:]
        def playerReboundsMap = [:]
        def playerStealsMap = [:]
        def playerBlocksMap = [:]
        def totalGames = 14
        def playerPPG, playerAPG, playerRPG, playerSPG, playerBPG

        playersList.each{ player ->

            def totalPoints=0, totalRebounds=0, totalAssists=0, totalSteals=0, totalBlocks=0
            player.gameStatsLog.each{ gameStat ->

                totalPoints += gameStat.points
                totalAssists += gameStat.assists
                totalRebounds += gameStat.rebounds
                totalSteals += gameStat.steals
                totalBlocks += gameStat.blocks
            }

            playerPPG = ((double)totalPoints/totalGames).round(1)
            playerAPG = ((double)totalAssists/totalGames).round(1)
            playerRPG = ((double)totalRebounds/totalGames).round(1)
            playerSPG = ((double)totalSteals/totalGames).round(1)
            playerBPG = ((double)totalBlocks/totalGames).round(1)

            playerPointsMap.put(player, playerPPG)
            playerAssistsMap.put(player, playerAPG)
            playerReboundsMap.put(player, playerRPG)
            playerStealsMap.put(player, playerSPG)
            playerBlocksMap.put(player, playerBPG)
        }

        return [points:playerPointsMap, assists:playerAssistsMap, rebounds:playerReboundsMap, steals:playerStealsMap, blocks:playerBlocksMap]
    }
}
