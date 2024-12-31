package tn.esprit.mokhlesbenna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.mokhlesbenna.entity.Rencontre;

import java.time.LocalDate;
import java.util.List;

public interface RencontreRepo extends JpaRepository<Rencontre, Long> {
    List<Rencontre> findByDateMatch(LocalDate date);
}

