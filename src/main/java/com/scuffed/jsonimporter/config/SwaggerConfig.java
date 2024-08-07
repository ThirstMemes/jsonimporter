package com.scuffed.jsonimporter.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
							 .group("public-apis")
				.pathsToMatch("/**").build();
	}
	
	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("ScuffedImporter")
											.version("0.1")
											.license(new License().name("Apache 2.0").url("http://springdoc.org")))
										  	.externalDocs(new ExternalDocumentation().description(
													  "Automated JSON API documentation for API's built with Spring.")
																					 .url("http://swagger.io/terms/"));
	}
}