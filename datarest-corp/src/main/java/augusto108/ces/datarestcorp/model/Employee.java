package augusto108.ces.datarestcorp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, of = {})
@Entity
@Table(name = "employee")
public final class Employee extends Person {
    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "registration", nullable = false, length = 12)
    private String registration;

    @Override
    public String toString() {
        return super.getName().toString() + " - " + description + " - " + registration;
    }
}
