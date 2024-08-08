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
					new Position(1, "Vergoldete Krücken"),
					new Position( 2, "Döner" ),
					new Position(3, "Racing Rollstuhl")
			};
			repository.saveAll(List.of(positions));
		};
	}
}