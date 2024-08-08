package com.scuffed.jsonimporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scuffed.jsonimporter.model.PatientPermissionType;
import com.scuffed.jsonimporter.model.enums.PatientPermissionTypeEnum;

public interface PatientPermissionTypeRepository extends JpaRepository<PatientPermissionType, PatientPermissionTypeEnum> {
}