package com.scuffed.jsonimporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scuffed.jsonimporter.model.PositionPrice;

public interface PositionPriceRepository extends JpaRepository<PositionPrice, Long> {
}