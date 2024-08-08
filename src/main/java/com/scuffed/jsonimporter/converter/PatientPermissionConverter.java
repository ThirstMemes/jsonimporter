package com.scuffed.jsonimporter.converter;

import java.util.Collection;
import java.util.List;
import com.scuffed.jsonimporter.dto.PatientPermissionDTO;
import com.scuffed.jsonimporter.model.PatientPermission;

public final class PatientPermissionConverter {
	
	private PatientPermissionConverter() {}
	
	public static PatientPermissionDTO toDTO(PatientPermission patientPermission) {
		return new PatientPermissionDTO(patientPermission.getPatientPermissionNumber(),
										patientPermission.getPermissionType());
	}
	
	public static List<PatientPermissionDTO> toDTOs(Collection<PatientPermission> dtos) {
		return dtos.stream().map(PatientPermissionConverter::toDTO).toList();
	}
	
	public static PatientPermission toEntity(PatientPermissionDTO dto) {
		return new PatientPermission(dto.patientPermissionNumber(),
									 dto.patientPermissionTypeEnum());
	}
	
	public static List<PatientPermission> toEntities(Collection<PatientPermissionDTO> dtos) {
		return dtos.stream().map(PatientPermissionConverter::toEntity).toList();
	}
}