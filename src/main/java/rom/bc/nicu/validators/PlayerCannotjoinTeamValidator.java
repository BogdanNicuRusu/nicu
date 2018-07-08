package rom.bc.nicu.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rom.bc.nicu.exception.team.PlayerCannotJoinTeamException;
import rom.bc.nicu.model.Player;
import rom.bc.nicu.model.Team;
import rom.bc.nicu.validators.predicates.PlayerCannotJoinTeamPredicate;

import java.util.List;

@Component
public class PlayerCannotjoinTeamValidator {

    @Autowired
    private List<PlayerCannotJoinTeamPredicate> predicates;

    public void validate(Player player, Team team) {
        predicates.stream()
                .filter(predicate -> predicate.test(player, team))
                .findFirst()
                .map(predicate -> {
                    throw new PlayerCannotJoinTeamException(predicate.getMessage(team.getId(), player.getId()));
                });
    }
}
