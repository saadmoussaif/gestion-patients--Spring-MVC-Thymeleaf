package com.saadmsf.patientsmvc;

import com.saadmsf.patientsmvc.entites.Patient;
import com.saadmsf.patientsmvc.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
     patientRepository.save(
             new Patient(null,"Hassan",new Date(),false,14));
            patientRepository.save(
                    new Patient(null,"saad",new Date(),true,100));
            patientRepository.save(
                    new Patient(null,"simo",new Date(),false,20));
            patientRepository.save(
                    new Patient(null,"Ahmed",new Date(),false,250));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());

            });
        };

}
}
