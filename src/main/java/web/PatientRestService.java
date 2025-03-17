package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import repositories.PatientRepository;
import entities.Patient;

import java.util.List;


@RestController
public class PatientRestService {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Patient> listPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}
