package com.scuffed.jsonimporter.config;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.scuffed.jsonimporter.model.Position;
import com.scuffed.jsonimporter.repository.PositionRepository;

@Configuration
public class PositionConfig {
	
	@Bean
	CommandLineRunner positionCLR(PositionRepository repository) {
		return args -> {
			Position[] positions = new Position[] {
					new Position("Vergoldete Krücken"),
					new Position("Döner" ),
					new Position("Racing Rollstuhl")
			};
			repository.saveAll(repository.saveAll(List.of(positions)));
		};
	}
}