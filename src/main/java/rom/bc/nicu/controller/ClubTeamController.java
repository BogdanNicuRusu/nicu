package rom.bc.nicu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rom.bc.nicu.dto.ClubTeamDto;
import rom.bc.nicu.model.ClubTeam;
import rom.bc.nicu.service.ClubTeamService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(path = "/clubTeams")
@Produces(APPLICATION_JSON)
public class ClubTeamController {

    @Autowired
    private ClubTeamService clubTeamService;

    @RequestMapping(method = PUT)
    @Consumes(APPLICATION_JSON)
    public ClubTeam createPlayer(@Valid @RequestBody ClubTeamDto player) {
        return clubTeamService.createClubTeam(player);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public ClubTeam getPlayerById(@PathVariable("id") String id) {
        return clubTeamService.findById(id);
    }
}
