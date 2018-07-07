package rom.bc.nicu.service

import rom.bc.nicu.dto.TeamDto
import rom.bc.nicu.exception.team.TeamAlreadyExistingException
import rom.bc.nicu.exception.team.TeamNotFoundException
import rom.bc.nicu.model.ClubTeam
import rom.bc.nicu.repository.TeamRepository
import spock.lang.Specification

import java.time.LocalDate

import static java.util.Optional.empty
import static java.util.Optional.of

class TeamServiceSpec extends Specification{

    TeamRepository clubTeamRepository = Mock()

    TeamDto clubTeamDto = new TeamDto("ClubTeam", "2000-10-10", "Romania")

    def service = new TeamService(clubTeamRepository)

    def "should create club team if it doesn't exist beforehand"() {
        given:
            clubTeamRepository.findByNameAndCountry(clubTeamDto.getName(), clubTeamDto.getCountry()) >> empty()
        when:
            service.createClubTeam(clubTeamDto)
        then:
            1 * clubTeamRepository.save(_ as ClubTeam)
            noExceptionThrown()
    }

    def "should throw exception if club team can not be created"() {
        given:
            clubTeamRepository.findByNameAndCountry(clubTeamDto.getName(), clubTeamDto.getCountry()) >> of(createClubTeam())
        when:
            service.createClubTeam(clubTeamDto)
        then:
            thrown(TeamAlreadyExistingException)
    }

    def "should throw exception if cannot find club team by id"() {
        given:
            def id = "id"
            clubTeamRepository.findById(id) >> empty()
        when:
            service.findById(id)
        then:
            thrown(TeamNotFoundException)
    }

    private static ClubTeam createClubTeam() {
        new ClubTeam("ClubTeam", LocalDate.of(2000, 10, 10), "Romania")
    }
}
