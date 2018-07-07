package rom.bc.nicu.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.bc.nicu.abstraction.Team;
import rom.bc.nicu.dto.TeamDto;
import rom.bc.nicu.exception.team.TeamAlreadyExistingException;
import rom.bc.nicu.exception.team.TeamNotFoundException;
import rom.bc.nicu.model.ClubTeam;
import rom.bc.nicu.model.Player;
import rom.bc.nicu.repository.TeamRepository;

import java.time.LocalDate;

import static java.time.LocalDate.parse;

@Service
@AllArgsConstructor
public class TeamService {

    private static final String ENTITY_TYPE = "Club team";

    private TeamRepository teamRepository;
    private PlayerService playerService;

    public ClubTeam createClubTeam(TeamDto teamDto) {
        teamRepository.findByNameAndCountry(teamDto.getName(), teamDto.getCountry())
                .ifPresent(it -> { throw new TeamAlreadyExistingException(teamDto);});
        ClubTeam clubTeam = convert(teamDto);
        teamRepository.save(clubTeam);
        return clubTeam;
    }

    public Team findById(String id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id, ENTITY_TYPE));
    }

    public Team addPlayerToTeam(String teamId, String playerId) {
        Team team = findById(teamId);
        Player player = playerService.findById(playerId);
        team.getPlayers().add(player);
        return team;
    }

    private ClubTeam convert(TeamDto teamDto) {
        LocalDate founded = parse(teamDto.getFounded());
        return new ClubTeam(teamDto.getName(), founded, teamDto.getCountry());
    }
}
