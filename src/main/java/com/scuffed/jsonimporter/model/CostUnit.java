package com.scuffed.jsonimporter.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "institutionalId" }))
public class CostUnit {
	
	@Id
	@SequenceGenerator(
			name = "cost_unit_sequence",
			sequenceName = "cost_unit_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "cost_unit_sequence"
	)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String institutionalId;
	
	@OneToMany(mappedBy = "costUnit", cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE }, orphanRemoval = true)
	private Set<Invoice> invoices = new HashSet<>();
	
	public CostUnit() {
	}
	
	public CostUnit(final String institutionalId, final String name) {
		this.institutionalId = institutionalId;
		this.name = name;
	}
	
	public CostUnit(final Long id, final String institutionalId, final String name) {
		this.id = id;
		this.institutionalId = institutionalId;
		this.name = name;
	}
	
	public void addInvoice(Invoice invoice) {
		invoices.add(invoice);
	}
	
	public void removeInvoice(Invoice invoice) {
		invoices.remove(invoice);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getInstitutionalId() {
		return institutionalId;
	}
	
	public void setInstitutionalId(final String institutionalId) {
		this.institutionalId = institutionalId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public Set<Invoice> getInvoices() {
		return invoices;
	}
	
	public void setInvoices(final Set<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("CostUnit{");
		sb.append("name='").append(name).append('\'');
		sb.append(", institutionalId='").append(institutionalId).append('\'');
		sb.append('}');
		return sb.toString();
	}
}