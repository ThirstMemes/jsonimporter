package com.scuffed.jsonimporter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scuffed.jsonimporter.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	Optional<Patient> findFirstPatientByFirstnameAndSurnameAndInsuranceNumber(String firstname, String surname, String insuranceNumber);
}