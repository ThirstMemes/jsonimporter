package com.scuffed.jsonimporter.converter;

import java.util.Collection;
import java.util.List;
import com.scuffed.jsonimporter.dto.BillingReceiptDTO;
import com.scuffed.jsonimporter.model.BillingReceipt;

public final class BillingReceiptConverter {
	
	private BillingReceiptConverter() {}
	
	public static BillingReceiptDTO toDTO(BillingReceipt billingReceipt) {
		return new BillingReceiptDTO(billingReceipt.getBillingReceiptNumber(),
									 billingReceipt.getCaseId());
	}
	
	public static List<BillingReceiptDTO> toDTOs(Collection<BillingReceipt> billingReceipt) {
		return billingReceipt.stream()
							 .map(BillingReceiptConverter::toDTO)
							 .toList();
	}
	
	public static BillingReceipt toEntity(BillingReceiptDTO dto) {
		return new BillingReceipt(dto.billingReceiptId(),
								  dto.caseId());
	}
	
	public static List<BillingReceipt> toEntities(Collection<BillingReceiptDTO> dtos) {
		return dtos.stream()
				   .map(BillingReceiptConverter::toEntity)
				   .toList();
	}
}