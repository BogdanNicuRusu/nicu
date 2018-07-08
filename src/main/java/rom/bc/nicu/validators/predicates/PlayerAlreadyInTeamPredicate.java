package rom.bc.nicu.validators.predicates;

import org.springframework.stereotype.Component;
import rom.bc.nicu.model.Team;
import rom.bc.nicu.model.Player;

@Component
public class PlayerAlreadyInTeamPredicate implements PlayerCannotJoinTeamPredicate {

    @Override
    public boolean test(Player player, Team team) {
        return team.getPlayers().contains(player);
    }

    @Override
    public String getMessage(String playerId, String teamId) {
        return String.format("Player with id %s already in the team with id %s", playerId, teamId);
    }
}
