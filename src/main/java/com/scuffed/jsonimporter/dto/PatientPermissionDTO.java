package com.scuffed.jsonimporter.dto;

import com.scuffed.jsonimporter.model.enums.PermissionType;

public record PatientPermissionDTO(String patientPermissionNumber, PermissionType permissionType) {}