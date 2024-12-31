package tn.esprit.mokhlesbenna.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import tn.esprit.mokhlesbenna.entity.enums.Niveau;

import java.time.LocalDate;

@Getter
@Entity
@Data
public class Rencontre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateMatch;
    private String nomStade;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    private int nbreBut = 0;

    @ManyToOne
    private Equipe equipe1;

    @ManyToOne
    private Equipe equipe2;

    @ManyToOne
    private Arbitre arbitre;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateMatch(LocalDate dateMatch) {
        this.dateMatch = dateMatch;
    }

    public void setNomStade(String nomStade) {
        this.nomStade = nomStade;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void setNbreBut(int nbreBut) {
        this.nbreBut = nbreBut;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }
}
