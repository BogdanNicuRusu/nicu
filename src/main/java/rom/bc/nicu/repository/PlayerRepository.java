package rom.bc.nicu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rom.bc.nicu.model.Player;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    Optional<Player> findByFirstNameAndLastNameAndBirthDate(String firstName, String lastName, LocalDate birthDate);

}
