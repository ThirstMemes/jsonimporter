package com.scuffed.jsonimporter.model;

import java.util.HashSet;
import java.util.Set;
import com.scuffed.jsonimporter.model.enums.PatientPermissionTypeEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class PatientPermissionType {
	
	@Id
	private PatientPermissionTypeEnum id;
	
	@NotBlank
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patientPermissionType", cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE }, orphanRemoval = true)
	private Set<PatientPermission> patientPermissions = new HashSet<>();
	
	public PatientPermissionType() {
	}
	
	public PatientPermissionType(final PatientPermissionTypeEnum id, @NotBlank final String description) {
		this.description = description;
		this.id = id;
	}
	
	public @NotBlank String getDescription() {
		return description;
	}
	
	public void setDescription(final @NotBlank String description) {
		this.description = description;
	}
	
	public PatientPermissionTypeEnum getId() {
		return id;
	}
	
	public void setId(final PatientPermissionTypeEnum id) {
		this.id = id;
	}
	
	public Set<PatientPermission> getPatientPermissions() {
		return patientPermissions;
	}
	
	public void setPatientPermissions(final Set<PatientPermission> patientPermissions) {
		this.patientPermissions = patientPermissions;
	}
}