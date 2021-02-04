package league

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(GameStats)
class GameStatsSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }

    void "test statistics not negative"(){

        when:
            def gameStats = new GameStats(minutesPlayed:35, points:19, rebounds:10, assists:8, steals:2, blocks:0,
                                          shotsAttempted:12, shotsMade:6, shotsPercentage:50, threesAttempted:5,
                                          threesMade:2, threesPercentage:40, personalFouls:3)
        then:
            !gameStats.validate()
        when:
            gameStats.minutesPlayed < 0
        then:
            !gameStats.validate()
        when:
            gameStats.points < 0
        then:
            !gameStats.validate()
        when:
            gameStats.rebounds < 0
        then:
            !gameStats.validate()
        when:
            gameStats.assists < 0
        then:
            !gameStats.validate()
        when:
            gameStats.steals < 0
        then:
            !gameStats.validate()
        when:
            gameStats.blocks < 0
        then:
            !gameStats.validate()
        when:
            gameStats.shotsAttempted < 0
        then:
            !gameStats.validate()
        when:
            gameStats.shotsMade < 0
        then:
            !gameStats.validate()
        when:
            gameStats.shotsPercentage < 0
        then:
            !gameStats.validate()
        when:
            gameStats.threesAttempted < 0
        then:
            !gameStats.validate()
        when:
            gameStats.threesMade < 0
        then:
            !gameStats.validate()
        when:
            gameStats.threesPercentage < 0
        then:
            !gameStats.validate()
        when:
        gameStats.personalFouls < 0
        then:
            !gameStats.validate()
    }

    void "test shotsAttempted not less than shotsMade"(){

        when:
            def gameStats = new GameStats(minutesPlayed:35, points:19, rebounds:10, assists:8, steals:2, blocks:0,
                shotsAttempted:12, shotsMade:6, shotsPercentage:50, threesAttempted:5,
                threesMade:2, threesPercentage:40, personalFouls:3)
        then:
            !gameStats.validate()
        when:
            gameStats.shotsAttempted < gameStats.shotsMade
        then:
            !gameStats.validate()
    }

    void "test threesAttempted not less than threesMade"(){

        when:
            def gameStats = new GameStats(minutesPlayed:35, points:19, rebounds:10, assists:8, steals:2, blocks:0,
                shotsAttempted:12, shotsMade:6, shotsPercentage:50, threesAttempted:5,
                threesMade:2, threesPercentage:40, personalFouls:3)
        then:
            !gameStats.validate()
        when:
            gameStats.threesAttempted < gameStats.threesMade
        then:
            !gameStats.validate()
    }

}
