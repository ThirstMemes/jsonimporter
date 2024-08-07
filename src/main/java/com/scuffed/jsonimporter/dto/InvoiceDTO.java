package com.scuffed.jsonimporter.dto;

import java.time.LocalDate;

public record InvoiceDTO(Long customerId,
						 Long invoiceNumber,
						 String customerTrackingNumber,
						 LocalDate creationDate,
						 PatientDTO patient,
						 BillingReceiptDTO billingReceipt,
						 CostUnitDTO costUnit,
						 PatientPermissionDTO patientPermission) {
}