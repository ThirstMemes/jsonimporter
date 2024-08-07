package com.scuffed.jsonimporter.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PositionAmountKey implements Serializable {
	
	@Column(name = "invoice_id")
	Long invoiceId;
	
	@Column(name = "position_id")
	Long positionId;
	
	public PositionAmountKey(final Long invoiceId, final Long positionId) {
		this.invoiceId = invoiceId;
		this.positionId = positionId;
	}
	
	public Long getInvoiceId() {
		return invoiceId;
	}
	
	public void setInvoiceId(final Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	public Long getPositionId() {
		return positionId;
	}
	
	public void setPositionId(final Long positionId) {
		this.positionId = positionId;
	}
	
	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final PositionAmountKey that = (PositionAmountKey) o;
		return Objects.equals(invoiceId, that.invoiceId) && Objects.equals(positionId, that.positionId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(invoiceId, positionId);
	}
}