package com.scuffed.jsonimporter.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.scuffed.jsonimporter.model.Position;
import com.scuffed.jsonimporter.model.PositionPrice;
import com.scuffed.jsonimporter.repository.PositionPriceRepository;
import com.scuffed.jsonimporter.repository.PositionRepository;

@Configuration
public class PositionConfig {
	
	@Bean
	CommandLineRunner positionCLR(PositionRepository positionRepository, PositionPriceRepository priceRepository) {
		return args -> {
			final Position[] positions = new Position[] {
					new Position("Vergoldete Krücken"),
					new Position("Döner" ),
					new Position("Racing Rollstuhl")
			};
			List<Position> savedPositions = positionRepository.saveAll(positionRepository.saveAll(List.of(positions)));
			
			PositionPrice[] prices = new PositionPrice[] {
					new PositionPrice(savedPositions.getFirst(), BigDecimal.valueOf(2299.99), LocalDate.of(2023, 3, 1), null),
					new PositionPrice(savedPositions.getFirst(), BigDecimal.valueOf(2099.99), LocalDate.of(2020, 1, 1), LocalDate.of(2023,3,1)),
					new PositionPrice(savedPositions.get(1), BigDecimal.valueOf(3.5), LocalDate.of(2005, 6, 1), LocalDate.of(2022,1,1)),
					new PositionPrice(savedPositions.get(1), BigDecimal.valueOf(6), LocalDate.of(2022,1,1), LocalDate.of(2025,1,1)),
					new PositionPrice(savedPositions.get(1), BigDecimal.valueOf(10), LocalDate.of(2025,1,1), null),
					new PositionPrice(savedPositions.getLast(), BigDecimal.valueOf(1500), LocalDate.of(2025,1,1), LocalDate.of(2027,1,1))
			};
			priceRepository.saveAll(List.of(prices));
		};
	}
}