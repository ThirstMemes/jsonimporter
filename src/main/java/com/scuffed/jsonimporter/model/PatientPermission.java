package com.scuffed.jsonimporter.model;

import com.scuffed.jsonimporter.model.enums.PatientPermissionTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "patient_permission_number" }))
public class PatientPermission {
	
	@Id
	@SequenceGenerator(
			name = "patient_permission_sequence",
			sequenceName = "patient_permission_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "patient_permission_sequence"
	)
	private Long id;
	
	@NotBlank
	private String patientPermissionNumber;
	
	private PatientPermissionTypeEnum patientPermissionTypeEnum;
	
	public PatientPermission() {
	}
	
	public PatientPermission(final String patientPermissionNumber, final PatientPermissionTypeEnum patientPermissionTypeEnum) {
		this.patientPermissionNumber = patientPermissionNumber;
		this.patientPermissionTypeEnum = patientPermissionTypeEnum;
	}
	
	public PatientPermission(final Long id, final String patientPermissionNumber, final PatientPermissionTypeEnum patientPermissionTypeEnum) {
		this.id = id;
		this.patientPermissionNumber = patientPermissionNumber;
		this.patientPermissionTypeEnum = patientPermissionTypeEnum;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getPatientPermissionNumber() {
		return patientPermissionNumber;
	}
	
	public void setPatientPermissionNumber(final String patientPermissionNumber) {
		this.patientPermissionNumber = patientPermissionNumber;
	}
	
	public PatientPermissionTypeEnum getPermissionType() {
		return patientPermissionTypeEnum;
	}
	
	public void setPermissionType(final PatientPermissionTypeEnum patientPermissionTypeEnum) {
		this.patientPermissionTypeEnum = patientPermissionTypeEnum;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PatientPermission{");
		sb.append("permissionIdentifier='").append(patientPermissionNumber).append('\'');
		sb.append(", permissionsType=").append(patientPermissionTypeEnum);
		sb.append('}');
		return sb.toString();
	}
}