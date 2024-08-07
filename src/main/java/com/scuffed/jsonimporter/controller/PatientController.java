package com.scuffed.jsonimporter.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scuffed.jsonimporter.dto.PatientDTO;
import com.scuffed.jsonimporter.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping
public class PatientController {
	
	private final PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@Tag(name = "Patienten", description = "Gibt alle Patienten zurück")
	@Operation(summary = "Gibt alle Patienten zurück.")
	@GetMapping(value = "/patients", produces = "application/json")
	public List<PatientDTO> getPatients() {
		return patientService.getPatients();
	}
	
	@Tag(name = "Patienten", description = "Fügt einen Patienten in die Datenbank ein.")
	@Operation(summary = "Fügt einen Patienten in die Datenbank ein.")
	@PostMapping(value = "/patient")
	public void insertPatient(@RequestBody PatientDTO dto) {
		patientService.insertPatient(dto);
	}
}