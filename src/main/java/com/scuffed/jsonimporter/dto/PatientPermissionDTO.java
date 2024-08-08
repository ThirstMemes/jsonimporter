package com.scuffed.jsonimporter.dto;

import com.scuffed.jsonimporter.model.enums.PatientPermissionTypeEnum;

public record PatientPermissionDTO(String patientPermissionNumber, PatientPermissionTypeEnum patientPermissionTypeEnum) {}