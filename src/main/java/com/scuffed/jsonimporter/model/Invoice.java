package com.scuffed.jsonimporter.model;

import java.time.LocalDate;
import java.util.Set;
import org.springframework.data.annotation.CreatedDate;
import com.scuffed.jsonimporter.model.enums.InvoiceStatusEnum;
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
import jakarta.validation.constraints.NotEmpty;
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
	
	@NotNull
	private Long customerId;
	
	@NotNull
	private String customerTrackingNumber;
	
	@NotNull
	@ManyToOne
	private InvoiceStatus status;
	
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
	
	@NotEmpty
	@OneToMany(mappedBy = "invoice")
	Set<PositionAmount> positionAmounts;
	
	public Invoice() {}
	
	public Invoice(final Long customerId,
				   final Long invoiceNumber,
				   final String customerTrackingNumber,
				   final InvoiceStatus status,
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
		this.status = status;
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
		this.status = new InvoiceStatus(InvoiceStatusEnum.OPEN, InvoiceStatusEnum.OPEN.getDescription());
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
	
	public @NotNull Long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(final @NotNull Long customerId) {
		this.customerId = customerId;
	}
	
	public @NotNull String getCustomerTrackingNumber() {
		return customerTrackingNumber;
	}
	
	public void setCustomerTrackingNumber(final @NotNull String customerTrackingNumber) {
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
	
	public void setInvoiceNumber(final @NotNull Long invoiceNumber) {
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
	
	public @NotEmpty Set<PositionAmount> getPositionAmounts() {
		return positionAmounts;
	}
	
	public void setPositionAmounts(final @NotEmpty Set<PositionAmount> positionAmounts) {
		this.positionAmounts = positionAmounts;
	}
	
	public void addPositionAmounts(final @NotNull PositionAmount positionAmount) {
		positionAmounts.add(positionAmount);
	}
	
	public @NotNull InvoiceStatus getStatus() {
		return status;
	}
	
	public void setStatus(final @NotNull InvoiceStatus status) {
		this.status = status;
	}
}