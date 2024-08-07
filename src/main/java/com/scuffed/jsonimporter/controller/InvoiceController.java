package com.scuffed.jsonimporter.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scuffed.jsonimporter.dto.InvoiceDTO;
import com.scuffed.jsonimporter.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping
public class InvoiceController {
	
	private final InvoiceService invoiceService;
	
	@Autowired
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@Tag(name = "Abrechnungen", description = "Gibt alle Abrechnungen zurück.")
	@Operation(summary = "Gibt alle Abrechnungen zurück.")
	@GetMapping("/invoices")
	public List<InvoiceDTO> getInvoices() {
		return invoiceService.getInvoices();
	}
	
	@Tag(name = "Abrechnungen", description = "Fügt eine Abrechnung in die Datenbank ein.")
	@Operation(summary = "Fügt eine Abrechnung in die Datenbank ein.")
	@PostMapping(value = "/invoice", produces = "application/json")
	public ResponseEntity<InvoiceDTO> insertInvoice(@RequestBody InvoiceDTO dto) {
		InvoiceDTO response = invoiceService.insertInvoice(dto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}