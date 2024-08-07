package com.scuffed.jsonimporter.converter;

import java.util.Collection;
import java.util.List;
import com.scuffed.jsonimporter.dto.InvoiceDTO;
import com.scuffed.jsonimporter.model.Invoice;

public final class InvoiceConverter {
	
	private InvoiceConverter() {}
	
	public static InvoiceDTO toDTO(Invoice invoice) {
		return new InvoiceDTO(invoice.getCustomerId(),
							  invoice.getInvoiceNumber(),
							  invoice.getCustomerTrackingNumber(),
							  invoice.getCreationDate(),
							  PatientConverter.toDTO(invoice.getPatient()),
							  BillingReceiptConverter.toDTO(invoice.getBillingReceipt()),
							  CostUnitConverter.toDTO(invoice.getCostUnit()),
							  PatientPermissionConverter.toDTO(invoice.getPatientPermission()));
	}
	
	public static List<InvoiceDTO> toDTOs(Collection<Invoice> dtos) {
		return dtos.stream()
				   .map(InvoiceConverter::toDTO)
				   .toList();
	}
	
	public static Invoice toEntity(InvoiceDTO dto) {
		return new Invoice(dto.customerId(), dto.invoiceNumber(), dto.customerTrackingNumber(), dto.creationDate(), BillingReceiptConverter.toEntity(dto.billingReceipt()),
						   CostUnitConverter.toEntity(dto.costUnit()),
						   PatientConverter.toEntity(dto.patient()),
						   PatientPermissionConverter.toEntity(dto.patientPermission())
		);
	}
	
	public static List<Invoice> toEntities(Collection<InvoiceDTO> dtos) {
		return dtos.stream().map(InvoiceConverter::toEntity).toList();
	}
}