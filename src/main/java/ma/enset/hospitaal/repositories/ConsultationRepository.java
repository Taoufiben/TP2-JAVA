package ma.enset.hospitaal.repositories;

import ma.enset.hospitaal.entities.Consultation;
import ma.enset.hospitaal.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
}
