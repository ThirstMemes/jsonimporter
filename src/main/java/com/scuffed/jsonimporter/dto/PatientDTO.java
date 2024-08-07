package com.scuffed.jsonimporter.dto;

import java.time.LocalDate;

public record PatientDTO(String surname, String firstname, LocalDate dayOfBirth, String insuranceNumber, AddressDTO address) {}