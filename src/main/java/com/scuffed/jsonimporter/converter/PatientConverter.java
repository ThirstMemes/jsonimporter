package com.scuffed.jsonimporter.converter;

import java.util.Collection;
import java.util.List;
import com.scuffed.jsonimporter.dto.PatientDTO;
import com.scuffed.jsonimporter.model.Patient;

public final class PatientConverter {
	
	private PatientConverter() {
	}
	
	public static PatientDTO toDTO(Patient patient) {
		return new PatientDTO(patient.getSurname(),
							  patient.getFirstname(),
							  patient.getDayOfBirth(),
							  patient.getInsuranceNumber(),
							  AddressConverter.toDTO(patient.getAdress()));
	}
	
	public static List<PatientDTO> toDTOs(Collection<Patient> patients) {
		return patients.stream().map(PatientConverter::toDTO).toList();
	}
	
	public static Patient toEntity(PatientDTO dto) {
		return new Patient(dto.firstname(), dto.surname(), dto.dayOfBirth(), AddressConverter.toEntity(dto.address()),
						   dto.insuranceNumber()
		);
	}
	
	public static List<Patient> toEntities(Collection<PatientDTO> dtos) {
		return dtos.stream().map(PatientConverter::toEntity).toList();
	}
}