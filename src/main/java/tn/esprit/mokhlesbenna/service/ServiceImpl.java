package tn.esprit.mokhlesbenna.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.mokhlesbenna.entity.*;
import tn.esprit.mokhlesbenna.repository.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class ServiceImpl implements IService {

    @Autowired
    private ArbitreRepo arbitreRepo;

    @Autowired
    private EquipeRepo equipeRepo;

    @Autowired
    private RencontreRepo rencontreRepo;

    @Override
    public Arbitre ajouterArbitre(Arbitre arbitre) {
        return arbitreRepo.save(arbitre);
    }

    @Override
    public Equipe ajouterEquipeEtJoueurs(Equipe equipe) {
        equipe.getJoueurs().forEach(j -> j.setEquipe(equipe));
        return equipeRepo.save(equipe);
    }

    @Override
    public Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, Long idEquipe1, Long idEquipe2) {
        rencontre.setEquipe1(equipeRepo.findById(idEquipe1).orElse(null));
        rencontre.setEquipe2(equipeRepo.findById(idEquipe2).orElse(null));
        return rencontreRepo.save(rencontre);
    }

    @Override
    public void affecterArbitreARencontre(String nom, String prenom, Long idR) throws Exception {
        Rencontre rencontre = rencontreRepo.findById(idR).orElse(null);
        Arbitre arbitre = arbitreRepo.findAll().stream()
                .filter(a -> a.getNom().equals(nom) && a.getPrenom().equals(prenom))
                .findFirst()
                .orElse(null);

        if (rencontre != null && arbitre != null) {
            if (rencontre.getNiveau() != arbitre.getNiveau()) {
                throw new Exception("Exception déclenchée");
            }
            rencontre.setArbitre(arbitre);
            rencontreRepo.save(rencontre);
        }
    }

    @Override
    @Scheduled(cron = "0 0 8 * * *")
    public void rencontreDeDateSys() {
        List<Rencontre> matches = rencontreRepo.findByDateMatch(LocalDate.now());
        log.info("Today's Matches: {}", matches);
    }

    @Override
    public void incrementerNbreBut(Long idRencontre) {
        Rencontre rencontre = rencontreRepo.findById(idRencontre).orElse(null);
        if (rencontre != null && rencontre.getDateMatch().equals(LocalDate.now())) {
            rencontre.setNbreBut(rencontre.getNbreBut() + 1);
            rencontreRepo.save(rencontre);
        }
    }

    @Override
    public List<Arbitre> recupererArbitresDUneEquipe(Long idEquipe) {
        return arbitreRepo.findArbitresByEquipe(idEquipe);
    }

    @Override
    public List<Rencontre> getMatchesForToday() {
        return null;
    }

    @Override
    public Rencontre getMatchById(Long id) {
        return null;
    }

    @Override
    public List<Rencontre> getAllMatches() {
        return null;
    }

    @Override
    public List<Equipe> getAllTeams() {
        return null;
    }

    @Override
    public List<Arbitre> getAllReferees() {
        return null;
    }

    @Override
    public Arbitre getRefereeById(Long id) {
        return arbitreRepo.findById(id).orElse(null);
    }
}
