package ma.ensa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Compte {
    @Id
    @GeneratedValue
    private int id;
    private double solde;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
