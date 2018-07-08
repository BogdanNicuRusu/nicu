package rom.bc.nicu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rom.bc.nicu.model.Team;
import rom.bc.nicu.dto.TeamDto;
import rom.bc.nicu.service.TeamService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(path = "/teams")
@Produces(APPLICATION_JSON)
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = PUT)
    @Consumes(APPLICATION_JSON)
    public Team createTeam(@Valid @RequestBody TeamDto player) {
        return teamService.createTeam(player);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public Team getTeamById(@PathVariable("id") String id) {
        return teamService.findById(id);
    }

    @RequestMapping(path = "/{teamId}/players/{playerId}", method = POST)
    public Team addPlayerToTeam(@PathVariable("teamId") String teamId, @PathVariable("playerId") String playerId) {
        return teamService.addPlayerToTeam(teamId, playerId);
    }
}
