package com.scuffed.jsonimporter.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scuffed.jsonimporter.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
	
	Optional<Position> findFirstByPositionNumber(Integer positionNumber);
	
}