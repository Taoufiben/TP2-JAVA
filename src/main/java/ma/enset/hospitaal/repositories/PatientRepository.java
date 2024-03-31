package ma.enset.hospitaal.repositories;

import ma.enset.hospitaal.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{
    Patient findByName(String name);
}
