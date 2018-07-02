package rom.bc.nicu.abstraction;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
public class BaseEntity {

    @Id
    private String id;

    BaseEntity() {
        this.id = UUID.randomUUID().toString();
    }
}
