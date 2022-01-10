package ma.ensa.model;

import lombok.Data;
import ma.ensa.model.enumer.IDENTITE;
import ma.ensa.model.enumer.PAYS;
import ma.ensa.model.enumer.TITRE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private TITRE titre;
    private String prenom;
    private String nom;
    private IDENTITE identite;
    private PAYS pays;
    private Long numIdentite;
    private Date expiration;
    private Date naissance;
    private String profession;
    private PAYS nationalite;
    private String adressePays;
    private String adresseLegale;
    private String ville;
    private Long gsm;
    private String email;


    protected Set<Long> transfertsIds;

}
