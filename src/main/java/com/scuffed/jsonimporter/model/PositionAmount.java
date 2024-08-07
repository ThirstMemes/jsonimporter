package com.scuffed.jsonimporter.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.NotNull;

@Entity
public class PositionAmount {
	
	@EmbeddedId
	PositionAmountKey id;
	
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	@MapsId("invoiceId")
	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	@MapsId("positionId")
	private Position position;
	
	@NotNull
	private Integer amount;
	
	public PositionAmount() {
	}
	
	public PositionAmount(final Integer amount, final PositionAmountKey id, final Invoice invoice, final Position position) {
		this.amount = amount;
		this.id = id;
		this.invoice = invoice;
		this.position = position;
	}
	
	public @NotNull Integer getAmount() {
		return amount;
	}
	
	public void setAmount(final @NotNull Integer amount) {
		this.amount = amount;
	}
	
	public PositionAmountKey getId() {
		return id;
	}
	
	public void setId(final PositionAmountKey id) {
		this.id = id;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}
	
	public void setInvoice(final Invoice invoice) {
		this.invoice = invoice;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(final Position position) {
		this.position = position;
	}
}