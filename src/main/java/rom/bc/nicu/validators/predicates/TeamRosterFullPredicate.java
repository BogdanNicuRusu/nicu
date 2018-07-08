package rom.bc.nicu.validators.predicates;

import org.springframework.stereotype.Component;
import rom.bc.nicu.model.Team;
import rom.bc.nicu.model.Player;

@Component
public class TeamRosterFullPredicate implements PlayerCannotJoinTeamPredicate {

    private static final int ROSTER_MAX_SIZE = 30;

    @Override
    public boolean test(Player player, Team team) {
        return team.getPlayers().size() >= ROSTER_MAX_SIZE;
    }

    @Override
    public String getMessage(String playerId, String teamId) {
        return String.format("Team with id %s has a full roster", teamId);
    }
}
