package ma.enset.gestionpatients2;

import entities.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repositories.PatientRepository;

import java.util.Date;

@SpringBootApplication
public class GestionPatients2Application implements CommandLineRunner {
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "Mohamed", new Date(), false));
        patientRepository.save(new Patient(null, "Sara", new Date(), true));
        patientRepository.save(new Patient(null, "Amine", new Date(), false));
        patientRepository.save(new Patient(null, "Nadia", new Date(), true));
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionPatients2Application.class, args);
    }

}
