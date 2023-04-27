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
@Table(name = "authority")
public final class Authority extends BaseEntity {
    @Column(name = "description", nullable = false, unique = true, length = 50)
    private String description;
}
