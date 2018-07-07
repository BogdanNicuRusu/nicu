package rom.bc.nicu.exception.team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import rom.bc.nicu.dto.TeamDto;

@Slf4j
@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY, reason="ClubTeam already existing")
public class TeamAlreadyExistingException extends RuntimeException {

    public TeamAlreadyExistingException(TeamDto teamDto) {
        log.error("Club team {} from {} already exists", teamDto.getName(), teamDto.getCountry());
    }
}
