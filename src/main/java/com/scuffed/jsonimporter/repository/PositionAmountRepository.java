package com.scuffed.jsonimporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scuffed.jsonimporter.model.PositionAmount;
import com.scuffed.jsonimporter.model.PositionAmountKey;

public interface PositionAmountRepository extends JpaRepository<PositionAmount, PositionAmountKey> {
}