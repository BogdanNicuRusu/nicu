package rom.bc.nicu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    private String country;
    @NotNull
    private boolean isNationalTeam;
}
