package rom.bc.nicu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rom.bc.nicu.model.Team;
import rom.bc.nicu.dto.TeamDto;
import rom.bc.nicu.exception.team.TeamAlreadyExistingException;
import rom.bc.nicu.exception.team.TeamNotFoundException;
import rom.bc.nicu.model.Player;
import rom.bc.nicu.repository.TeamRepository;
import rom.bc.nicu.validators.PlayerCannotjoinTeamValidator;
import rom.bc.nicu.validators.predicates.PlayerCannotJoinTeamPredicate;

import java.util.List;

import static java.time.LocalDate.parse;

@Service
public class TeamService {

    private static final String ENTITY_TYPE = "Club team";

    private TeamRepository teamRepository;
    private PlayerService playerService;
    private PlayerCannotjoinTeamValidator validator;

    @Autowired
    public TeamService(TeamRepository teamRepository,
                       PlayerService playerService,
                       PlayerCannotjoinTeamValidator validator) {
        this.teamRepository = teamRepository;
        this.playerService = playerService;
        this.validator = validator;
    }

    public Team createTeam(TeamDto teamDto) {
        teamRepository.findByNameAndCountry(teamDto.getName(), teamDto.getCountry())
                .ifPresent(it -> { throw new TeamAlreadyExistingException(teamDto);});
        Team clubTeam = convert(teamDto);
        teamRepository.save(clubTeam);
        return clubTeam;
    }

    public Team findById(String id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id, ENTITY_TYPE));
    }

    public Team addPlayerToTeam(String teamId, String playerId) {
        Team team = findById(teamId);
        Player player = playerService.findById(playerId);
        applyValidators(player, team);
        addPlayerToTeam(player, team);
        return team;
    }

    private Team convert(TeamDto teamDto) {
        return new Team(teamDto.getName(), teamDto.getCountry(), teamDto.isNationalTeam());
    }

    private void applyValidators(Player player, Team team) {
        validator.validate(player, team);
    }

    private void addPlayerToTeam(Player player, Team team) {
        team.getPlayers().add(player);
        teamRepository.save(team);
    }
}
