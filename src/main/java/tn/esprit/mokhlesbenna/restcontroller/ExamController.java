package tn.esprit.mokhlesbenna.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.mokhlesbenna.entity.*;
import tn.esprit.mokhlesbenna.service.IService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExamController {

    @Autowired
    private IService service;

    // POST: Add a referee
    @PostMapping("/addReferee")
    public Arbitre ajouterArbitre(@RequestBody Arbitre arbitre) {
        return service.ajouterArbitre(arbitre);
    }

    // GET: Get all referees
    @GetMapping("/referees")
    public List<Arbitre> getAllReferees() {
        return service.getAllReferees();
    }

    // GET: Get referee by ID
    @GetMapping("/referee/{id}")
    public Arbitre getRefereeById(@PathVariable Long id) {
        return service.getRefereeById(id);  // Call service method to retrieve referee by ID
    }

    // POST: Add a team and players
    @PostMapping("/addTeamAndPlayers")
    public Equipe ajouterEquipeEtJoueurs(@RequestBody Equipe equipe) {
        return service.ajouterEquipeEtJoueurs(equipe);
    }

    // GET: Get all teams
    @GetMapping("/teams")
    public List<Equipe> getAllTeams() {
        return service.getAllTeams();
    }

    // POST: Add a match and assign teams
    @PostMapping("/addMatch")
    public Rencontre ajouterRencontreEtAffecterEquipes(@RequestBody Rencontre rencontre,
                                                       @RequestParam Long idEquipe1,
                                                       @RequestParam Long idEquipe2) {
        return service.ajouterRencontreEtAffecterEquipes(rencontre, idEquipe1, idEquipe2);
    }

    // GET: Get all matches
    @GetMapping("/matches")
    public List<Rencontre> getAllMatches() {
        return service.getAllMatches();
    }

    // GET: Get a match by ID
    @GetMapping("/match/{id}")
    public Rencontre getMatchById(@PathVariable Long id) {
        return service.getMatchById(id);
    }

    // POST: Assign referee to a match
    @PostMapping("/assignReferee")
    public void affecterArbitreARencontre(@RequestParam String nom,
                                          @RequestParam String prenom,
                                          @RequestParam Long idR) throws Exception {
        service.affecterArbitreARencontre(nom, prenom, idR);
    }

    // GET: Get all referees for a specific team
    @GetMapping("/referees/forTeam/{idEquipe}")
    public List<Arbitre> getRefereesForTeam(@PathVariable Long idEquipe) {
        return service.recupererArbitresDUneEquipe(idEquipe);
    }

    // GET: Get all matches scheduled for today
    @GetMapping("/matches/today")
    public List<Rencontre> getMatchesForToday() {
        return service.getMatchesForToday();
    }

    // GET: Increment goals for a match
    @GetMapping("/incrementGoals/{id}")
    public void incrementerNbreBut(@PathVariable Long id) {
        service.incrementerNbreBut(id);
    }
}
