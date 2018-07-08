package rom.bc.nicu.validators.predicates;

import rom.bc.nicu.model.Team;
import rom.bc.nicu.model.Player;

import java.util.function.BiPredicate;

public interface PlayerCannotJoinTeamPredicate extends BiPredicate<Player, Team> {

    String getMessage(String playerId, String teamId);
}
