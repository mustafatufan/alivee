package com.ionia.alivee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AliveeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AliveeApplication.class, args);
	}
}
