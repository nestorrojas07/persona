package com.nestorrojas07.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
@EnableAsync
@ComponentScan(basePackages= {"com.nestorrojas07"})
public class BlacksipApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BlacksipApplication.class, args);
	}
}
