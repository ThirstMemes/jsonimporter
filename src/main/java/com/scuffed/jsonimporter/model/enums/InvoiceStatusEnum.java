package com.scuffed.jsonimporter.model.enums;

import jakarta.validation.constraints.NotBlank;

public enum InvoiceStatusEnum {
	OPEN("Offen"),
	IN_PROGRESS("In Bearbeitung"),
	CLOSED("Abgeschlossen");
	
	@NotBlank
	private final String description;
	
	InvoiceStatusEnum(final String description) {
		this.description = description;
	}
	
	public @NotBlank String getDescription() {
		return description;
	}
}