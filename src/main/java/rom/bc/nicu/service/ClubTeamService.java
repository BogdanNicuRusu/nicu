package rom.bc.nicu.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.bc.nicu.dto.ClubTeamDto;
import rom.bc.nicu.exception.team.TeamAlreadyExistingException;
import rom.bc.nicu.exception.team.TeamNotFoundException;
import rom.bc.nicu.model.ClubTeam;
import rom.bc.nicu.repository.ClubTeamRepository;

import java.time.LocalDate;

import static java.time.LocalDate.parse;

@Service
@AllArgsConstructor
public class ClubTeamService {

    private static final String ENTITY_TYPE = "Club team";

    private ClubTeamRepository clubTeamRepository;

    public ClubTeam createClubTeam(ClubTeamDto clubTeamDto) {
        clubTeamRepository.findByNameAndCountry(clubTeamDto.getName(), clubTeamDto.getCountry())
                .ifPresent(it -> { throw new TeamAlreadyExistingException(clubTeamDto);});
        ClubTeam clubTeam = convert(clubTeamDto);
        clubTeamRepository.save(clubTeam);
        return clubTeam;
    }

    public ClubTeam findById(String id) {
        return clubTeamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id, ENTITY_TYPE));
    }

    private ClubTeam convert(ClubTeamDto clubTeamDto) {
        LocalDate founded = parse(clubTeamDto.getFounded());
        return new ClubTeam(clubTeamDto.getName(), founded, clubTeamDto.getCountry());
    }
}
