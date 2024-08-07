package com.scuffed.jsonimporter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scuffed.jsonimporter.model.BillingReceipt;

@Repository
public interface BillingReceiptRepository extends JpaRepository<BillingReceipt, Long> {
	
	Optional<BillingReceipt> findFirstByBillingReceiptNumber(String billingReceiptNumber);
}