package com.scuffed.jsonimporter.model;

import java.util.HashSet;
import java.util.Set;
import com.scuffed.jsonimporter.model.constant.IdConstants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "positionNumber" }))
public class Position {
	
	@Id
	@SequenceGenerator(
			name = "position_sequence",
			sequenceName = "position_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "position_sequence"
	)
	private Long id;
	
	@NotNull
	private Long positionNumber;
	
	@NotBlank
	private String description;
	
	@OneToMany(mappedBy = "position")
	Set<PositionAmount> positionAmounts;
	
	@NotEmpty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "position", cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE }, orphanRemoval = true)
	private Set<PositionPrice> positionPrices = new HashSet<>();
	
	public Position() {
	}
	
	public Position(final String description) {
		this.description = description;
	}
	
	public Position(final Long id, final Long positionNumber, final String description) {
		this.description = description;
		this.id = id;
		this.positionNumber = positionNumber;
	}
	
	@PostPersist
	private void generatePositionNumber() {
		positionNumber = IdConstants.BASE + id * IdConstants.PROCESS_RESERVE + 4;
	}
	
	public void addPositionPrice(PositionPrice positionPrice) {
		positionPrices.add(positionPrice);
		positionPrice.setPosition(this);
	}
	
	public void removePositionPrice(PositionPrice positionPrice) {
		positionPrices.remove(positionPrice);
		positionPrice.setPosition(null);
	}
	
	public @NotBlank String getDescription() {
		return description;
	}
	
	public void setDescription(final @NotBlank String description) {
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public @NotNull Long getPositionNumber() {
		return positionNumber;
	}
	
	public void setPositionNumber(final @NotNull Long positionNumber) {
		this.positionNumber = positionNumber;
	}
	
	public @NotEmpty Set<PositionPrice> getPositionPrices() {
		return positionPrices;
	}

	public void setPositionPrices(final @NotEmpty Set<PositionPrice> positionPrices) {
		this.positionPrices = positionPrices;
	}

	
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Position{");
		sb.append("positionNumber=").append(positionNumber);
		sb.append(", description='").append(description).append('\'');
		sb.append('}');
		return sb.toString();
	}
}