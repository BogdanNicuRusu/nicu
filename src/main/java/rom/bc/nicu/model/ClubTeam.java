package rom.bc.nicu.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import rom.bc.nicu.abstraction.Team;

import java.time.LocalDate;

@Getter
@Setter
public class ClubTeam extends rom.bc.nicu.abstraction.Team {

    private LocalDate founded;
    private String country;

    public ClubTeam(String name, LocalDate founded, String country) {
        super(name);
        this.founded = founded;
        this.country = country;
    }
}
