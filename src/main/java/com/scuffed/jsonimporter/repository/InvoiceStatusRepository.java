package com.scuffed.jsonimporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scuffed.jsonimporter.model.InvoiceStatus;
import com.scuffed.jsonimporter.model.enums.InvoiceStatusEnum;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, InvoiceStatusEnum> {
}