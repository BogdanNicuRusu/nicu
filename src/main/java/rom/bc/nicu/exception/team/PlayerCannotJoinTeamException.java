package rom.bc.nicu.exception.team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Player can not join team")
public class PlayerCannotJoinTeamException extends RuntimeException {

    public PlayerCannotJoinTeamException(String message) {
        log.error(message);
    }
}
