package league

class GameStatsTagLib {

    //Changed to raw encoding
    static defaultEncodeAs = [taglib:'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "stats"

    /**
     * Taglib for displaying total stats of a player
     *
     * @attr person
     */
    def totalStats = { attrs, body ->

        def totalMins=0, totalPts=0, totalAst=0, totalReb=0, totalStl=0, totalBlk=0
        def totalFgm=0, totalFga=0, total3pm=0, total3pa=0, totalPfs=0
        def player = attrs.player

        //Calculate totals for minutes, points, assists, rebounds, steals, blocks, fgm, fga, 3pm, 3pa, pfs
        player.gameStatsLog.each{ gameStats ->

            totalMins += gameStats.minutesPlayed
            totalPts += gameStats.points
            totalAst += gameStats.assists
            totalReb += gameStats.rebounds
            totalStl += gameStats.steals
            totalBlk += gameStats.blocks
            totalFgm += gameStats.shotsMade
            totalFga += gameStats.shotsAttempted
            total3pm += gameStats.threesMade
            total3pa += gameStats.threesAttempted
            totalPfs += gameStats.personalFouls
        }

        def totalsList = []
        totalsList.add(totalMins)
        totalsList.add(totalPts)
        totalsList.add(totalReb)
        totalsList.add(totalAst)
        totalsList.add(totalStl)
        totalsList.add(totalBlk)
        totalsList.add(totalFgm)
        totalsList.add(totalFga)
        totalsList.add(total3pm)
        totalsList.add(total3pa)
        totalsList.add(totalPfs)

        out << render(template:'seasonStatsTable', model:[seasonList:totalsList])
    }

    /**
     * Taglib for displaying average stats of a player
     *
     * @attr person
     */
    def averageStats = { attrs, body ->

        def totalMins=0, totalPts=0, totalAst=0, totalReb=0, totalStl=0, totalBlk=0
        def totalFgm=0, totalFga=0, total3pm=0, total3pa=0, totalPfs=0
        def player = attrs.player

        //Calculate totals for minutes, points, assists, rebounds, steals, blocks, fgm, fga, 3pm, 3pa, pfs
        player.gameStatsLog.each{ gameStats ->

            totalMins += gameStats.minutesPlayed
            totalPts += gameStats.points
            totalAst += gameStats.assists
            totalReb += gameStats.rebounds
            totalStl += gameStats.steals
            totalBlk += gameStats.blocks
            totalFgm += gameStats.shotsMade
            totalFga += gameStats.shotsAttempted
            total3pm += gameStats.threesMade
            total3pa += gameStats.threesAttempted
            totalPfs += gameStats.personalFouls
        }

        def averagesList = []
        averagesList.add(((double)totalMins/14).round(1))
        averagesList.add(((double)totalPts/14).round(1))
        averagesList.add(((double)totalReb/14).round(1))
        averagesList.add(((double)totalAst/14).round(1))
        averagesList.add(((double)totalStl/14).round(1))
        averagesList.add(((double)totalBlk/14).round(1))
        averagesList.add(((double)totalFgm/14).round(1))
        averagesList.add(((double)totalFga/14).round(1))
        averagesList.add(((double)total3pm/14).round(1))
        averagesList.add(((double)total3pa/14).round(1))
        averagesList.add(((double)totalPfs/14).round(1))

        out << render(template:'seasonStatsTable', model:[seasonList:averagesList])
    }

}