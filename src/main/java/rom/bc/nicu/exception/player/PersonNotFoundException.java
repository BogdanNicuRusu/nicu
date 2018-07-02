package rom.bc.nicu.exception.player;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Person not found")
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String playerId, String entityType) {
        log.error("{} with id {} not found", entityType, playerId);
    }

}
