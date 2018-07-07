package rom.bc.nicu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rom.bc.nicu.model.ClubTeam;

import java.util.Optional;

@Repository
public interface TeamRepository extends MongoRepository<ClubTeam, String> {

    Optional<ClubTeam> findByNameAndCountry(String name, String country);
}
