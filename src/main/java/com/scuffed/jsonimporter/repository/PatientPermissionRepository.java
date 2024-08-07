package com.scuffed.jsonimporter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scuffed.jsonimporter.model.PatientPermission;

@Repository
public interface PatientPermissionRepository extends JpaRepository<PatientPermission, Long> {
	
	Optional<PatientPermission> findFirstByPatientPermissionNumber(String patientPermissionNumber);
}