package rom.bc.nicu.service

import rom.bc.nicu.dto.PlayerDto
import rom.bc.nicu.exception.player.PersonAlreadyExistingException
import rom.bc.nicu.exception.player.PersonNotFoundException
import rom.bc.nicu.model.Player
import rom.bc.nicu.repository.PlayerRepository
import rom.bc.nicu.service.PlayerService
import spock.lang.Specification

import java.time.LocalDate

import static java.time.LocalDate.parse
import static java.util.Optional.empty
import static java.util.Optional.of
import static rom.bc.nicu.model.Player.PreferredFoot.RIGHT

class PlayerServiceSpec extends Specification {

    PlayerRepository playerRepository = Mock()

    def playerDto = new PlayerDto("John", "Doe", "2000-01-01")

    def service = new PlayerService(playerRepository)

    def "should create player if it doesn't exist beforehand"() {
        given:
            playerRepository.findByFirstNameAndLastNameAndBirthDate(
                    playerDto.getFirstName(), playerDto.getLastName(),
                    parse(playerDto.getBirthDate())) >> empty()
        when:
            service.createPlayer(playerDto)
        then:
            1 * playerRepository.save(_ as Player)
            noExceptionThrown()
    }

    def "should throw exception if player can not be created"() {
        given:
            playerRepository.findByFirstNameAndLastNameAndBirthDate(
                playerDto.getFirstName(), playerDto.getLastName(),
                parse(playerDto.getBirthDate())) >> of(createNewPlayer())
        when:
            service.createPlayer(playerDto)
        then:
            thrown(PersonAlreadyExistingException)
    }

    def "should throw exception if cannot find player by id"() {
        given:
            def id = "id"
            playerRepository.findById(id) >> empty()
        when:
            service.findById(id)
        then:
            thrown(PersonNotFoundException)
    }

    private static Player createNewPlayer() {
        new Player("John", "Doe", LocalDate.of(2000, 10, 10))
    }
}
