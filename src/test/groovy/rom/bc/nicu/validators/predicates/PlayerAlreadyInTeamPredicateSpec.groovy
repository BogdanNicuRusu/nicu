package rom.bc.nicu.validators.predicates

import rom.bc.nicu.model.Player
import rom.bc.nicu.model.Team
import spock.lang.Specification

class PlayerAlreadyInTeamPredicateSpec extends Specification {

    Player player = Mock()
    Team team = Mock()

    def predicate = new PlayerAlreadyInTeamPredicate()

    def "should return false if player is not in the team"() {
        given:
            team.getPlayers() >> Collections.emptyList()
        expect:
            !predicate.test(player, team)
    }

    def "should return true if player is already in the team"() {
        given:
            team.getPlayers() >> Collections.singletonList(player)
        expect:
            predicate.test(player, team)
    }
}
