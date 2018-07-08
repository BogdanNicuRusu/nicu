package rom.bc.nicu.model;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import rom.bc.nicu.model.abstraction.BaseEntity;

import java.util.Collections;
import java.util.List;

@Getter
@Document(collection = "teams")
public class Team extends BaseEntity {

    private String name;
    private String country;
    private boolean isNationalTeam;
    private List<Player> players;

    public Team(String name, String country, boolean isNationalTeam) {
        super();
        this.name = name;
        this.country = country;
        this.isNationalTeam = isNationalTeam;
        this.players = Collections.emptyList();
    }

    public List<Player> getPlayers() {
        return players;
    }

}
