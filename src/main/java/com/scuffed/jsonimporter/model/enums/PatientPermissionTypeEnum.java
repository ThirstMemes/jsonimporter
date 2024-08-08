package com.scuffed.jsonimporter.model.enums;

import jakarta.validation.constraints.NotBlank;

public enum PatientPermissionTypeEnum {
	STANDARD("Standardverodnung"),
	NON_STANDARD("Sonderverordnung"),
	PRIVATE("Privat");
	
	@NotBlank
	private final String description;
	
	PatientPermissionTypeEnum(final String description) {
		this.description = description;
	}
	
	public @NotBlank String getDescription() {
		return description;
	}
}