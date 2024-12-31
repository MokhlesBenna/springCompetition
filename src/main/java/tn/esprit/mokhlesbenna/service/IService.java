package tn.esprit.mokhlesbenna.service;

import tn.esprit.mokhlesbenna.entity.*;

import java.util.List;

public interface IService {
    Arbitre ajouterArbitre(Arbitre arbitre);

    Equipe ajouterEquipeEtJoueurs(Equipe equipe);

    Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, Long idEquipe1, Long idEquipe2);

    void affecterArbitreARencontre(String nom, String prenom, Long idR) throws Exception;

    void rencontreDeDateSys();

    void incrementerNbreBut(Long idRencontre);

    List<Arbitre> recupererArbitresDUneEquipe(Long idEquipe);

    List<Rencontre> getMatchesForToday();

    Rencontre getMatchById(Long id);

    List<Rencontre> getAllMatches();

    List<Equipe> getAllTeams();

    List<Arbitre> getAllReferees();

    Arbitre getRefereeById(Long id);
}
