package ma.enset.hospitaal.services;

import ma.enset.hospitaal.entities.*;

import java.util.Optional;

public interface IHospitalService {
     Patient savePatient(Patient patient);
     Product saveProduct(Product product);

     Patient find_P(Long i);
     Patient findbyName(String n);
     Medecin findbyname(String n);

     RendezVous find_All();

    Medecin saveMedecin(Medecin medecin);
     Medecin find_M(Long s);
     Consultation saveConsultation(Consultation consultation);
     RendezVous saveRDV(RendezVous rendezVous);
}
