package rom.bc.nicu.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import rom.bc.nicu.abstraction.Person;

import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "players")
public class Player extends Person {

    private PreferredFoot preferredFoot;

    public Player(String firstName,
                  String lastName,
                  LocalDate birthDate,
                  PreferredFoot preferredFoot) {
        super(firstName, lastName, birthDate);
        this.preferredFoot = preferredFoot;
    }

    public enum PreferredFoot {
        LEFT, RIGHT, BOTH
    }

}
