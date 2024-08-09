package com.scuffed.jsonimporter.model;

import com.scuffed.jsonimporter.model.constant.IdConstants;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "billingReceipt_number" }))
public class BillingReceipt {
	
	@Id
	@SequenceGenerator(
			name = "billing_receipt_sequence",
			sequenceName = "billing_receipt_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "billing_receipt_sequence"
	)
	private Long id;
	
	@NotBlank
	private String billingReceiptNumber;
	
	private String caseId;
	
	public BillingReceipt() {
	}
	
	public BillingReceipt(final String billingReceiptNumber, final String caseId) {
		this.billingReceiptNumber = billingReceiptNumber;
		this.caseId = caseId;
	}
	
	public BillingReceipt(final Long id, final String billingReceiptNumber, final String caseId) {
		this.id = id;
		this.caseId = caseId;
		this.billingReceiptNumber = billingReceiptNumber;
	}
	
	@PostPersist
	private void generateBillingReceiptNumberAndCaseId() {
		if(billingReceiptNumber == null || billingReceiptNumber.isBlank()) {
			billingReceiptNumber = "ABG-" + (IdConstants.BASE + id * IdConstants.PROCESS_RESERVE + 2);
		}
		if(caseId == null || caseId.isBlank()) {
			caseId = "C-" + (IdConstants.BASE + id * IdConstants.PROCESS_RESERVE + 3);
		}
	}
	
	public String getBillingReceiptNumber() {
		return billingReceiptNumber;
	}
	
	public void setBillingReceiptNumber(final String billingReceiptNumber) {
		this.billingReceiptNumber = billingReceiptNumber;
	}
	
	public String getCaseId() {
		return caseId;
	}
	
	public void setCaseId(final String caseId) {
		this.caseId = caseId;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("BillingReceipt{");
		sb.append("billingReceiptId='").append(billingReceiptNumber).append('\'');
		sb.append(", caseId='").append(caseId).append('\'');
		sb.append('}');
		return sb.toString();
	}
}