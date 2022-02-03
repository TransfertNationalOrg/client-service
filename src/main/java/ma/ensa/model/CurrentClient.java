package ma.ensa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CurrentClient {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    protected Long theId;
}
