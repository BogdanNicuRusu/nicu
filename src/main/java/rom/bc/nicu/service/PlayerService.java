package rom.bc.nicu.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.bc.nicu.dto.PlayerDto;
import rom.bc.nicu.exception.player.PersonAlreadyExistingException;
import rom.bc.nicu.exception.player.PersonNotFoundException;
import rom.bc.nicu.model.Player;
import rom.bc.nicu.repository.PlayerRepository;

import java.time.LocalDate;

import static java.time.LocalDate.parse;

@Service
@AllArgsConstructor
public class PlayerService {

    private static final String ENTITY_TYPE = "Player";

    private PlayerRepository playerRepository;

    public Player createPlayer(PlayerDto playerDto) {
        playerRepository.findByFirstNameAndLastNameAndBirthDate(playerDto.getFirstName(), playerDto.getLastName(), parse(playerDto.getBirthDate()))
                .ifPresent(it -> { throw new PersonAlreadyExistingException(playerDto);});
        Player player = convert(playerDto);
        playerRepository.save(player);
        return player;
    }

    public Player findById(String id) {
        return playerRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id, ENTITY_TYPE));
    }

    private Player convert(PlayerDto playerDto) {
        LocalDate birthDate = parse(playerDto.getBirthDate());
        return new Player(playerDto.getFirstName(), playerDto.getLastName(), birthDate);
    }
}

