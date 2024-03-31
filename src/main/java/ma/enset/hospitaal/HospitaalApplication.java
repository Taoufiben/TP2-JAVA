package ma.enset.hospitaal;


import ma.enset.hospitaal.entities.*;
import ma.enset.hospitaal.repositories.*;

import ma.enset.hospitaal.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class   HospitaalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitaalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(//PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository
                            //
                            ProductRepository productRepository,
                            IHospitalService hospitalService) {
        return args -> {
            Stream.of("Amine","Issam","Taoufik").forEach(name ->{
                    Patient patient=new Patient();
                    patient.setName(name);
                    patient.setMalade(false);
                    patient.setDateNaissance(new Date());

                    hospitalService.savePatient(patient);
            });
            Stream.of("Mohamed","Mariam","skfkf").forEach(name ->{
                Medecin medecin=new Medecin();
                medecin.setName(name);
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste") ;
                medecin.setEmail(name+"@gmail.com");
                hospitalService.saveMedecin(medecin);
            });
            Patient patient=hospitalService.find_P(1L);
            Patient patient1=hospitalService .findbyName("Taoufik");
            Medecin medecin=hospitalService.findbyname("Mariam");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setStatus(StatusRDV.Pending);
            rendezVous.setDate(new Date());
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient) ;
            RendezVous sevadeRDV =hospitalService.saveRDV(rendezVous);
            System.out.println(sevadeRDV.getId());
            RendezVous rendezVous1=hospitalService.find_All();
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Le rapport par la consultation ............. ");
            hospitalService.saveConsultation(consultation);
            Stream.of("Telephone","Laptop","Hassoub").forEach(name->{
                Product product=new Product();
                product.setName(name);
                product.setPrice(Math.random()>0.5?15000:20000);
                product.setQuantity(Math.random()>0.5?200:150);
                hospitalService.saveProduct(product);
            });
                List<Product> productList=productRepository.findAll();
                productList.forEach(ps->{
                    System.out.println(ps.getId());
                    System.out.println(ps.getName());
                    System.out.println(ps.getPrice());
                    System.out.println(ps.getQuantity());
                    System.out.println("\\\\==================================//");
                });
                    Product product1=productRepository.findById(1L).orElse(null);
                    product1.setQuantity(125);
                    productRepository.save(product1);
                    Product product2=productRepository.findById(2L).orElse(null);
                    if(product2!=null) {
                        productRepository.delete(product2);
                    }


        } ;


    }
}
