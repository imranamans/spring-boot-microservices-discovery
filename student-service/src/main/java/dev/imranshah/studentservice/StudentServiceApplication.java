package dev.imranshah.studentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class StudentServiceApplication {

	public static void main(String[] args) {
//		SpringApplication.run(StudentServiceApplication.class, args);
		SpringApplication springApplication = new SpringApplication(StudentServiceApplication.class);
		springApplication.setApplicationStartup(new BufferingApplicationStartup(10000));
		springApplication.run(args);
	}
}
