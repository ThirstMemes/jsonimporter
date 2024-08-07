package com.scuffed.jsonimporter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scuffed.jsonimporter.converter.PatientConverter;
import com.scuffed.jsonimporter.dto.PatientDTO;
import com.scuffed.jsonimporter.repository.PatientRepository;

@Service
public class PatientService {
	
	private final PatientRepository patientRepository;
	
	@Autowired
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	public List<PatientDTO> getPatients() {
		return PatientConverter.toDTOs(patientRepository.findAll());
	}
	
	public void insertPatient(PatientDTO dto) {
		PatientConverter.toDTO(patientRepository.save(PatientConverter.toEntity(dto)));
	}
}