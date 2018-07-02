package rom.bc.nicu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rom.bc.nicu.dto.PlayerDto;
import rom.bc.nicu.model.Player;
import rom.bc.nicu.service.PlayerService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(path = "/players")
@Produces(APPLICATION_JSON)
public class PlayersController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = PUT)
    @Consumes(APPLICATION_JSON)
    public Player createPlayer(@Valid @RequestBody PlayerDto player) {
        return playerService.createPlayer(player);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public Player getPlayerById(@PathVariable("id") String id) {
        return playerService.findById(id);
    }
}
