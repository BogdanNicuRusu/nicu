package rom.bc.nicu.exception.player;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import rom.bc.nicu.dto.PlayerDto;

@Slf4j
@ResponseStatus(value= HttpStatus.UNPROCESSABLE_ENTITY, reason="Person already existing")
public class PersonAlreadyExistingException extends RuntimeException {

    public PersonAlreadyExistingException(PlayerDto player) {
        log.error("Player named {} {} born on {} has already been added",
                player.getFirstName(), player.getLastName(), player.getBirthDate());
    }

}
