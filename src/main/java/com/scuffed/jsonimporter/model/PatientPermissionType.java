package com.scuffed.jsonimporter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class PatientPermissionType {
	
	@Id
	@SequenceGenerator(
			name = "patient_permission_type_sequence",
			sequenceName = "patient_permission_type_sequence",
			allocationSize = 1
	)
	private Integer id;
	
	private String description;
	
	
}