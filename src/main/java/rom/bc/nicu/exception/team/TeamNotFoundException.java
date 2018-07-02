package rom.bc.nicu.exception.team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Team not found")
public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(String teamId, String entityType) {
        log.error("{} with id {} not found", entityType, teamId);
    }
}
