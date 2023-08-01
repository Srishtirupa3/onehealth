// Import required classes from the Spring Framework
package com.oneHealth.doctorSchedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

// Define the main class for the Spring Boot application
@SpringBootApplication
@RestController
public class DemoApplication {

	// The main method to start the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
}
