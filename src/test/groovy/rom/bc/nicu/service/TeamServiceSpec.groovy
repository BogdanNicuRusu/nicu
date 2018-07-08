package rom.bc.nicu.service

import rom.bc.nicu.dto.TeamDto
import rom.bc.nicu.exception.team.PlayerCannotJoinTeamException
import rom.bc.nicu.exception.team.TeamAlreadyExistingException
import rom.bc.nicu.exception.team.TeamNotFoundException
import rom.bc.nicu.model.Player
import rom.bc.nicu.model.Team
import rom.bc.nicu.repository.TeamRepository
import rom.bc.nicu.validators.PlayerCannotjoinTeamValidator
import rom.bc.nicu.validators.predicates.PlayerCannotJoinTeamPredicate
import spock.lang.Specification

import static java.util.Optional.empty
import static java.util.Optional.of

class TeamServiceSpec extends Specification{

    Team team = Mock()
    Player player = Mock()
    PlayerCannotjoinTeamValidator validator = Mock()
    TeamRepository teamRepository = Mock()
    PlayerService playerService = Mock()

    TeamDto teamDto = new TeamDto("team", "Romania", false)

    def service = new TeamService(teamRepository, playerService, validator)

    def "should create club team if it doesn't exist beforehand"() {
        given:
            teamRepository.findByNameAndCountry(teamDto.getName(), teamDto.getCountry()) >> empty()
        when:
            service.createTeam(teamDto)
        then:
            1 * teamRepository.save(_ as Team)
            noExceptionThrown()
    }

    def "should throw exception if club team can not be created"() {
        given:
            teamRepository.findByNameAndCountry(teamDto.getName(), teamDto.getCountry()) >> of(team)
        when:
            service.createTeam(teamDto)
        then:
            thrown(TeamAlreadyExistingException)
    }

    def "should throw exception if cannot find club team by id"() {
        given:
            def id = "id"
            teamRepository.findById(id) >> empty()
        when:
            service.findById(id)
        then:
            thrown(TeamNotFoundException)
    }

}
