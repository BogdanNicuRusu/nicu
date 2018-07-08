package rom.bc.nicu.model.abstraction;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
public class BaseEntity {

    @Id
    private String id;

    protected BaseEntity() {
        this.id = UUID.randomUUID().toString();
    }
}
