package rom.bc.nicu.service

import rom.bc.nicu.dto.ClubTeamDto
import rom.bc.nicu.exception.team.TeamAlreadyExistingException
import rom.bc.nicu.exception.team.TeamNotFoundException
import rom.bc.nicu.model.ClubTeam
import rom.bc.nicu.repository.ClubTeamRepository
import spock.lang.Specification

import java.time.LocalDate

import static java.util.Optional.empty
import static java.util.Optional.of

class ClubTeamServiceSpec extends Specification{

    ClubTeamRepository clubTeamRepository = Mock()

    ClubTeamDto clubTeamDto = new ClubTeamDto("Team", "2000-10-10", "Romania")

    def service = new ClubTeamService(clubTeamRepository)

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
        new ClubTeam("Team", LocalDate.of(2000, 10, 10), "Romania")
    }
}
