package com.scuffed.jsonimporter.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class PositionPrice {
	
	@Id
	@SequenceGenerator(
			name = "position_price_sequence",
			sequenceName = "position_price_sequence",
			allocationSize = 1
	)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	private Position position;
	
	private BigDecimal price;
	
	@NotNull
	@FutureOrPresent
	private LocalDate validityFrom;
	
	//@FutureOrPresent
	private LocalDate validityUntil;
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(final BigDecimal price) {
		this.price = price;
	}
	
	public @NotNull @FutureOrPresent LocalDate getValidityFrom() {
		return validityFrom;
	}
	
	public void setValidityFrom(final @NotNull @FutureOrPresent LocalDate validityFrom) {
		this.validityFrom = validityFrom;
	}
	
	public @FutureOrPresent LocalDate getValidityUntil() {
		return validityUntil;
	}
	
	public void setValidityUntil(final @FutureOrPresent LocalDate validityUntil) {
		this.validityUntil = validityUntil;
	}
}