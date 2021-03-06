package ma.ensa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Compte {
    @Id
    @GeneratedValue
    protected Long id;
    protected double solde;
    protected Date date;
    protected Long idClient;

}
