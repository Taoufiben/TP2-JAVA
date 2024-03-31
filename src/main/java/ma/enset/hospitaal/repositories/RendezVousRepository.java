package ma.enset.hospitaal.repositories;

import ma.enset.hospitaal.entities.Patient;
import ma.enset.hospitaal.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String>{
}
