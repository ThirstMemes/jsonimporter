package com.scuffed.jsonimporter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scuffed.jsonimporter.converter.InvoiceConverter;
import com.scuffed.jsonimporter.dto.InvoiceDTO;
import com.scuffed.jsonimporter.model.Invoice;
import com.scuffed.jsonimporter.model.Patient;
import com.scuffed.jsonimporter.repository.BillingReceiptRepository;
import com.scuffed.jsonimporter.repository.CostUnitRepository;
import com.scuffed.jsonimporter.repository.InvoiceRepository;
import com.scuffed.jsonimporter.repository.PatientPermissionRepository;
import com.scuffed.jsonimporter.repository.PatientRepository;
import com.scuffed.jsonimporter.repository.PositionRepository;

@Service
public class InvoiceService {
	
	private final InvoiceRepository invoiceRepository;
	private final BillingReceiptRepository billingReceiptRepository;
	private final CostUnitRepository costUnitRepository;
	private final PatientPermissionRepository patientPermissionRepository;
	private final PatientRepository patientRepository;
	private final PositionRepository positionRepository;
	
	@Autowired
	public InvoiceService(final BillingReceiptRepository billingReceiptRepository, final InvoiceRepository invoiceRepository, final CostUnitRepository costUnitRepository,
						  final PatientPermissionRepository patientPermissionRepository, final PatientRepository patientRepository, final PositionRepository positionRepository) {
		this.billingReceiptRepository = billingReceiptRepository;
		this.invoiceRepository = invoiceRepository;
		this.costUnitRepository = costUnitRepository;
		this.patientPermissionRepository = patientPermissionRepository;
		this.patientRepository = patientRepository;
		this.positionRepository = positionRepository;
	}
	
	public List<InvoiceDTO> getInvoices() {
		return InvoiceConverter.toDTOs(invoiceRepository.findAll());
	}
	
	public InvoiceDTO insertInvoice(InvoiceDTO dto) {
		Invoice entity = InvoiceConverter.toEntity(dto);
		Patient patient = entity.getPatient();
		billingReceiptRepository.findFirstByBillingReceiptNumber(entity.getBillingReceipt().getBillingReceiptNumber()).ifPresent(entity::setBillingReceipt);
		costUnitRepository.findFirstByInstitutionalId(entity.getCostUnit().getInstitutionalId()).ifPresent(entity::setCostUnit);
		patientPermissionRepository.findFirstByPatientPermissionNumber(entity.getPatientPermission().getPatientPermissionNumber()).ifPresent(entity::setPatientPermission);
		patientRepository.findFirstPatientByFirstnameAndSurnameAndInsuranceNumber(patient.getFirstname(), patient.getSurname(), patient.getInsuranceNumber()).ifPresent(entity::setPatient);
		// positionRepository
		return InvoiceConverter.toDTO(invoiceRepository.save(InvoiceConverter.toEntity(dto)));
	}
}