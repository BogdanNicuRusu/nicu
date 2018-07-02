package rom.bc.nicu.model;

import org.springframework.data.mongodb.core.mapping.Document;
import rom.bc.nicu.abstraction.Person;

import java.time.LocalDate;

@Document(collection = "coaches")
public class Coach extends Person {

    public Coach(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }
}
