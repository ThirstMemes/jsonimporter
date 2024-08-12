package com.scuffed.jsonimporter.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "position_price_sequence"
	)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Position position;
	
	private BigDecimal price;
	
	@NotNull
	//@FutureOrPresent
	private LocalDate validityFrom;
	
	//@FutureOrPresent
	private LocalDate validityUntil;
	
	public PositionPrice() {
	}
	
	public PositionPrice(final Position position, final BigDecimal price, final LocalDate validityFrom, final LocalDate validityUntil) {
		this.position = position;
		this.price = price;
		this.validityFrom = validityFrom;
		this.validityUntil = validityUntil;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(final Position position) {
		this.position = position;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(final BigDecimal price) {
		this.price = price;
	}
	
	public @NotNull @FutureOrPresent LocalDate getValidityFrom() {
		return validityFrom;
	}
	
	public void setValidityFrom(final @NotNull /*@FutureOrPresent*/ LocalDate validityFrom) {
		this.validityFrom = validityFrom;
	}
	
	public LocalDate getValidityUntil() {
		return validityUntil;
	}
	
	public void setValidityUntil(final LocalDate validityUntil) {
		this.validityUntil = validityUntil;
	}
}