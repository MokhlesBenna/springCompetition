package tn.esprit.mokhlesbenna.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import tn.esprit.mokhlesbenna.entity.enums.Poste;

@Getter
@Entity
@Data
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private Poste poste;

    private int numMaillot;

    @ManyToOne
    private Equipe equipe;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public void setNumMaillot(int numMaillot) {
        this.numMaillot = numMaillot;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
