package com.nestorrojas07.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlacksipApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BlacksipApplication.class, args);
	}
}
