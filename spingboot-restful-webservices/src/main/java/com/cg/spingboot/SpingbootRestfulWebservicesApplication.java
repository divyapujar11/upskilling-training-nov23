package com.cg.spingboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "SPring Boot Rest API Documentation",
				description = "Spring boot Rest DOcmentation",
				version = "v1.0" ,
				contact = @Contact(
						name ="Ramesh",
						email = "ramesh@gmail.com",
						url = "https://www.javaguides.com"
						),
				license = @License(
						name = "hfduj",
						url = "https://ewgfwj.net/license"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "sprint boot user management documentation",
				url = "https://www.javaguides.com"
				)
		)
public class SpingbootRestfulWebservicesApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpingbootRestfulWebservicesApplication.class, args);
	}

}
