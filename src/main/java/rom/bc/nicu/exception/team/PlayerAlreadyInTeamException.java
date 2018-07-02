package rom.bc.nicu.exception.team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Player already present in team's roster")
public class PlayerAlreadyInTeamException extends RuntimeException{

    public PlayerAlreadyInTeamException(String playerId, String teamId) {
        log.error("Player with id {} already in the team with id {}", playerId, teamId);
    }
}
