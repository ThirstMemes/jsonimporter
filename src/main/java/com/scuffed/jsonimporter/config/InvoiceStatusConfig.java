package com.scuffed.jsonimporter.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.scuffed.jsonimporter.model.InvoiceStatus;
import com.scuffed.jsonimporter.model.enums.InvoiceStatusEnum;
import com.scuffed.jsonimporter.repository.InvoiceStatusRepository;

@Configuration
public class InvoiceStatusConfig {
	
	@Bean
	CommandLineRunner invoiceStatusCLR(InvoiceStatusRepository repository) {
		return args -> {
			List<InvoiceStatus> patientPermissionTypes = Arrays.stream(InvoiceStatusEnum.values())
															   .map(e -> new InvoiceStatus(e, e.getDescription()))
															   .toList();
			repository.saveAll(patientPermissionTypes);
		};
	}
}