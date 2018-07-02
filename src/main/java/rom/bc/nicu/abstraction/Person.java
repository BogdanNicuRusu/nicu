package rom.bc.nicu.abstraction;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public abstract class Person extends BaseEntity{

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    protected Person(String firstName, String lastName, LocalDate birthDate) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (getClass() != obj.getClass())) {
            return false;
        }
        final Person other = (Person) obj;
        return this.firstName.equals(other.getFirstName())
                && this.lastName.equals(other.getLastName())
                && this.birthDate.equals(other.getBirthDate());
    }
}
