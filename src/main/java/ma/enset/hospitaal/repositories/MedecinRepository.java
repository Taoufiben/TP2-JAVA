package ma.enset.hospitaal.repositories;

import ma.enset.hospitaal.entities.Medecin;
import ma.enset.hospitaal.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long>{
    Medecin findByName(String name); 
}
