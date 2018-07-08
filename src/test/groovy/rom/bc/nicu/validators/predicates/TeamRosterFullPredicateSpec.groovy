package rom.bc.nicu.validators.predicates

import rom.bc.nicu.model.Player
import rom.bc.nicu.model.Team
import spock.lang.Specification
import spock.lang.Unroll

class TeamRosterFullPredicateSpec extends Specification {

    Player player = Mock()
    Team team = Mock()
    List<Player> players = Mock()

    def predicate = new TeamRosterFullPredicate()

    @Unroll
    def "should return #result when team roster size is #size"() {
        given:
            team.getPlayers() >> players
            players.size() >> size
        expect:
            result == predicate.test(player, team)
        where:
            result | size
            false  | 0
            false  | 29
            true   | 30
    }
}
