package com.scuffed.jsonimporter.model;

import com.scuffed.jsonimporter.model.enums.InvoiceStatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class InvoiceStatus {
	
	@Id
	private InvoiceStatusEnum id;
	
	@NotBlank
	private String description;
	
	
	public InvoiceStatus() {
	}
	
	public InvoiceStatus(final InvoiceStatusEnum id, final String description) {
		this.description = description;
		this.id = id;
	}
	
	public @NotBlank String getDescription() {
		return description;
	}
	
	public void setDescription(final @NotBlank String description) {
		this.description = description;
	}
	
	public InvoiceStatusEnum getId() {
		return id;
	}
	
	public void setId(final InvoiceStatusEnum id) {
		this.id = id;
	}
}