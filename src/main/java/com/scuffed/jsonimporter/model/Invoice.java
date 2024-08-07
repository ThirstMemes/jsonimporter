package com.scuffed.jsonimporter.model;

import java.time.LocalDate;
import java.util.Set;
import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Invoice {
	
	@Id
	@SequenceGenerator(
			name = "invoice_sequence",
			sequenceName = "invoice_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "invoice_sequence"
	)
	private Long id;
	@NotNull
	private Long invoiceNumber;
	private Long customerId;
	private String customerTrackingNumber;
	@CreatedDate
	private LocalDate creationDate;
	
	@NotNull
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@NotNull
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "billing_receipt_id")
	private BillingReceipt billingReceipt;
	
	@NotNull
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "costUnit_id")
	private CostUnit costUnit;
	
	@NotNull
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "patient_permission_id")
	private PatientPermission patientPermission;
	
	@OneToMany(mappedBy = "invoice")
	Set<PositionAmount> positionAmounts;
	
	public Invoice() {}
	
	public Invoice(final Long customerId,
				   final Long invoiceNumber,
				   final String customerTrackingNumber,
				   final LocalDate creationDate,
				   final BillingReceipt billingReceipt,
				   final CostUnit costUnit,
				   final Patient patient,
				   final PatientPermission patientPermission) {
		this.billingReceipt = billingReceipt;
		this.costUnit = costUnit;
		this.creationDate = creationDate;
		this.customerId = customerId;
		this.customerTrackingNumber = customerTrackingNumber;
		this.patient = patient;
		this.patientPermission = patientPermission;
		this.invoiceNumber = invoiceNumber;
	}
	
	public Invoice(final Long id,
				   final Long invoiceNumber,
				   final Long customerId,
				   final String customerTrackingNumber,
				   final LocalDate creationDate,
				   final BillingReceipt billingReceipt,
				   final CostUnit costUnit,
				   final Patient patient,
				   final PatientPermission patientPermission) {
		this.billingReceipt = billingReceipt;
		this.costUnit = costUnit;
		this.creationDate = creationDate;
		this.customerId = customerId;
		this.customerTrackingNumber = customerTrackingNumber;
		this.id = id;
		this.patient = patient;
		this.patientPermission = patientPermission;
		this.invoiceNumber = invoiceNumber;
	}
	
	public @NotNull BillingReceipt getBillingReceipt() {
		return billingReceipt;
	}
	
	public void setBillingReceipt(final @NotNull BillingReceipt billingReceipt) {
		this.billingReceipt = billingReceipt;
	}
	
	public @NotNull CostUnit getCostUnit() {
		return costUnit;
	}
	
	public void setCostUnit(final @NotNull CostUnit costUnit) {
		this.costUnit = costUnit;
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(final LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(final Long customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerTrackingNumber() {
		return customerTrackingNumber;
	}
	
	public void setCustomerTrackingNumber(final String customerTrackingNumber) {
		this.customerTrackingNumber = customerTrackingNumber;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public @NotNull Long getInvoiceNumber() {
		return invoiceNumber;
	}
	
	public void setInvoiceNumber(final Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	public @NotNull Patient getPatient() {
		return patient;
	}
	
	public void setPatient(final @NotNull Patient patient) {
		this.patient = patient;
	}
	
	public @NotNull PatientPermission getPatientPermission() {
		return patientPermission;
	}
	
	public void setPatientPermission(final @NotNull PatientPermission patientPermission) {
		this.patientPermission = patientPermission;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Invoice{");
		sb.append("billingReceipt=").append(billingReceipt);
		sb.append(", customerId=").append(customerId);
		sb.append(", patient=").append(patient);
		sb.append(", creationDate=").append(creationDate);
		sb.append(", costUnit=").append(costUnit);
		sb.append(", patientPermission=").append(patientPermission);
		sb.append('}');
		return sb.toString();
	}
}