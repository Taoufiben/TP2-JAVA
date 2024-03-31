package ma.enset.hospitaal.services;

import jakarta.transaction.Transactional;
import ma.enset.hospitaal.entities.*;
import ma.enset.hospitaal.repositories.*;
import org.hibernate.annotations.DialectOverride;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImp implements IHospitalService{
    private ConsultationRepository consultationRepository;
    private MedecinRepository medecinRepository;
    private PatientRepository patientRepository;
    private RendezVousRepository rendezVousRepository;
    private ProductRepository productRepository;

    public HospitalServiceImp(ConsultationRepository consultation, MedecinRepository medecinRepository, PatientRepository patientRepository, RendezVousRepository rendezVousRepository, ProductRepository productRepository) {
        this.consultationRepository = consultation;
        this.medecinRepository = medecinRepository;
        this.patientRepository = patientRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.productRepository = productRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Patient find_P(Long i) {
        return patientRepository.findById(i).orElse(null);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin find_M(Long s) {
        return medecinRepository.findById(s).orElse(null);
    }
    @Override
    public Patient findbyName(String n){
        return patientRepository.findByName(n);
    }
    @Override
    public Medecin findbyname(String n){
        return medecinRepository.findByName(n);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation) ;
    }
    @Override
    public RendezVous find_All(){
        return rendezVousRepository.findAll().get(0 );
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous );
    }
}
