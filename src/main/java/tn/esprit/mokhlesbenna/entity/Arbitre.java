package tn.esprit.mokhlesbenna.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import tn.esprit.mokhlesbenna.entity.enums.Niveau;

@Getter
@Entity
@Data
public class Arbitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String nationalite;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
