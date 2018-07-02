package rom.bc.nicu.abstraction;

import lombok.Getter;

@Getter
public abstract class Team extends BaseEntity {

    private String name;

    protected Team(String name) {
        super();
        this.name = name;
    }

}
