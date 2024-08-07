package com.scuffed.jsonimporter.model;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class Patient {
	
	@Id
	@SequenceGenerator(
			name = "patient_sequence",
			sequenceName = "patient_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "patient_sequence"
	)
	private Long id;
	
	@NotBlank
	private String surname;
	
	@NotBlank
	private String firstname;
	
	private LocalDate dayOfBirth;
	
	@NotBlank
	private String insuranceNumber;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "address_id")
	private Address address;
	
	public Patient() {
	}
	
	public Patient(final String firstname, final String surname, final LocalDate dayOfBirth, final Address address, final String insuranceNumber) {
		this.address = address;
		this.dayOfBirth = dayOfBirth;
		this.firstname = firstname;
		this.insuranceNumber = insuranceNumber;
		this.surname = surname;
	}
	
	public Patient(final Long id, final String firstname, final String surname, final LocalDate dayOfBirth, final Address address, final String insuranceNumber) {
		this.address = address;
		this.dayOfBirth = dayOfBirth;
		this.firstname = firstname;
		this.id = id;
		this.insuranceNumber = insuranceNumber;
		this.surname = surname;
	}
	
	
	public Address getAdress() {
		return address;
	}
	
	public void setAdress(final Address address) {
		this.address = address;
	}
	
	public LocalDate getDayOfBirth() {
		return dayOfBirth;
	}
	
	public void setDayOfBirth(final LocalDate dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	
	public void setInsuranceNumber(final String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(final String surname) {
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Patient{");
		sb.append("surname='").append(surname).append('\'');
		sb.append(", firstname='").append(firstname).append('\'');
		sb.append(", address=").append(address);
		sb.append(", dayOfBirth=").append(dayOfBirth);
		sb.append(", insuranceNumber='").append(insuranceNumber).append('\'');
		sb.append('}');
		return sb.toString();
	}
}