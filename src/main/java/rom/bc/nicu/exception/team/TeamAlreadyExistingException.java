package rom.bc.nicu.exception.team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import rom.bc.nicu.dto.ClubTeamDto;

@Slf4j
@ResponseStatus(value= HttpStatus.UNPROCESSABLE_ENTITY, reason="Team already existing")
public class TeamAlreadyExistingException extends RuntimeException {

    public TeamAlreadyExistingException(ClubTeamDto clubTeamDto) {
        log.error("Club team {} from {} already exists", clubTeamDto.getName(), clubTeamDto.getCountry());
    }
}
