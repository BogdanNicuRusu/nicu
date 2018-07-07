package rom.bc.nicu.abstraction;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import rom.bc.nicu.model.Player;

import java.util.Collections;
import java.util.List;

@Getter
@Document(collection = "teams")
public abstract class Team extends BaseEntity {

    private String name;
    private List<Player> players;

    protected Team(String name) {
        super();
        this.name = name;
        this.players = Collections.emptyList();
    }

    public List<Player> getPlayers() {
        return players;
    }

}
