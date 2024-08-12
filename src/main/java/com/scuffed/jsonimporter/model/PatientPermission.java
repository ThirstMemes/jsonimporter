package com.scuffed.jsonimporter.model;

import com.scuffed.jsonimporter.model.constant.IdConstants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostPersist;
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
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "patient_permission_type_id")
	private PatientPermissionType patientPermissionType;
	
	public PatientPermission() {
	}
	
	public PatientPermission(final String patientPermissionNumber) {
		this.patientPermissionNumber = patientPermissionNumber;
	}
	
	public PatientPermission(final Long id, final String patientPermissionNumber) {
		this.id = id;
		this.patientPermissionNumber = patientPermissionNumber;
	}
	
	@PostPersist
	private void generatePatientPermissionNumber() {
		if(patientPermissionNumber == null || patientPermissionNumber.isBlank()) {
			patientPermissionNumber = "PPN-" + (IdConstants.BASE + id * IdConstants.PROCESS_RESERVE + 5);
		}
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public @NotBlank String getPatientPermissionNumber() {
		return patientPermissionNumber;
	}
	
	public void setPatientPermissionNumber(final @NotBlank String patientPermissionNumber) {
		this.patientPermissionNumber = patientPermissionNumber;
	}
	
	public PatientPermissionType getPatientPermissionType() {
		return patientPermissionType;
	}
	
	public void setPatientPermissionType(final PatientPermissionType patientPermissionType) {
		this.patientPermissionType = patientPermissionType;
	}
}