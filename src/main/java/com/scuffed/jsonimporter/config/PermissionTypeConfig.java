package com.scuffed.jsonimporter.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.scuffed.jsonimporter.model.PatientPermissionType;
import com.scuffed.jsonimporter.model.enums.PatientPermissionTypeEnum;
import com.scuffed.jsonimporter.repository.PatientPermissionTypeRepository;

@Configuration
public class PermissionTypeConfig {
	
	@Bean
	CommandLineRunner permissionCLR(PatientPermissionTypeRepository repository) {
		return args -> {
			List<PatientPermissionType> patientPermissionTypes = Arrays.stream(PatientPermissionTypeEnum.values())
																	   .map(e -> new PatientPermissionType(e, e.getDescription()))
																	   .toList();
			repository.saveAll(patientPermissionTypes);
		};
	}
}