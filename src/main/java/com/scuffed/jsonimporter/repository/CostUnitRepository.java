package com.scuffed.jsonimporter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scuffed.jsonimporter.model.CostUnit;

@Repository
public interface CostUnitRepository extends JpaRepository<CostUnit, Long> {
	
	Optional<CostUnit> findFirstByInstitutionalId(String institutionalId);
}