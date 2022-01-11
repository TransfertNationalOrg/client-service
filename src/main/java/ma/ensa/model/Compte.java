package ma.ensa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Compte {
    @Id
    @GeneratedValue
    protected int id;
    protected double solde;
    protected Date date;
    @ManyToOne
    @JoinColumn(name = "client_id")
    protected Client client;

}
