package augusto108.ces.datarestcorp.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, of = {})
@Entity
@Table(name = "hr_employee")
public final class HREmployee extends BaseEntity {
    @Column(name = "hr_username", nullable = false, unique = true, length = 50)
    private String hrUsername;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "active", nullable = false, length = 1)
    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "hr_employees_authorities",
            joinColumns = @JoinColumn(name = "hr_employee_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private final Collection<Authority> authorities = new HashSet<>();
}
