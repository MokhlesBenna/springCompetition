package tn.esprit.mokhlesbenna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.mokhlesbenna.entity.Arbitre;

import java.util.List;

@Repository
public interface ArbitreRepo extends JpaRepository<Arbitre, Long> {
    @Query("SELECT DISTINCT a FROM Arbitre a " +
            "JOIN Rencontre r ON r.arbitre.id = a.id " +
            "WHERE r.equipe1.id = :idEquipe OR r.equipe2.id = :idEquipe")
    List<Arbitre> findArbitresByEquipe(@Param("idEquipe") Long idEquipe);
}
