package com.scuffed.jsonimporter.model;

import com.scuffed.jsonimporter.model.enums.PatientPermissionTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class PatientPermissionType {
	
	@Id
	private PatientPermissionTypeEnum id;
	
	@NotBlank
	private String description;
	
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
}