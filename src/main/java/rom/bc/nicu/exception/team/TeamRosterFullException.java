package rom.bc.nicu.exception.team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY, reason="ClubTeam's roster is full")
public class TeamRosterFullException extends RuntimeException {

    public TeamRosterFullException(String teamId) {
        log.error("ClubTeam with id {} has a full roster");
    }

}
