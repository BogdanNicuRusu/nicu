package rom.bc.nicu.abstraction;

import lombok.Getter;
import rom.bc.nicu.model.Player;

import java.util.List;

@Getter
public abstract class Team extends BaseEntity {

    private String name;
    private List<Player> players;

    protected Team(String name) {
        super();
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

}
