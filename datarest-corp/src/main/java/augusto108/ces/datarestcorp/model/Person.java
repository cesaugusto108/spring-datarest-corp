package augusto108.ces.datarestcorp.model;

import augusto108.ces.datarestcorp.model.enums.Gender;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, of = {})
@MappedSuperclass
public abstract sealed class Person extends BaseEntity permits Employee {
    @Embedded
    private Name name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
