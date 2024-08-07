package com.scuffed.jsonimporter.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "street", "plz", "city" }))
public class Address {
	
	@Id
	@SequenceGenerator(
			name = "address_sequence",
			sequenceName = "address_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "address_sequence"
	)
	private Long id;
	
	@NotBlank
	private String street;
	
	@NotNull
	private Integer plz;
	
	@NotBlank
	private String city;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address", cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE }, orphanRemoval = true)
	private Set<Patient> patients = new HashSet<>();
	
	public Address() {
	}
	
	public Address(final String city, final Integer plz, final String street) {
		this.city = city;
		this.plz = plz;
		this.street = street;
	}
	
	public Address(final Long id, final String city, final Integer plz, final String street) {
		this.city = city;
		this.id = id;
		this.plz = plz;
		this.street = street;
	}
	
	public void addPatient(Patient patient) {
		patients.add(patient);
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(final String city) {
		this.city = city;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public Integer getPlz() {
		return plz;
	}
	
	public void setPlz(final Integer plz) {
		this.plz = plz;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(final String street) {
		this.street = street;
	}
	
	public Set<Patient> getPatients() {
		return patients;
	}
	
	public void setPatients(final Set<Patient> patients) {
		this.patients = patients;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Address{");
		sb.append("city='").append(city).append('\'');
		sb.append(", street='").append(street).append('\'');
		sb.append(", plz=").append(plz);
		sb.append('}');
		return sb.toString();
	}
}