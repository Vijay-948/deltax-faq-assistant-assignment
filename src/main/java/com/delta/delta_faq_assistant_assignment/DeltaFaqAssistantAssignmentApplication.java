package com.delta.delta_faq_assistant_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DeltaFaqAssistantAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeltaFaqAssistantAssignmentApplication.class, args);
	}

}
