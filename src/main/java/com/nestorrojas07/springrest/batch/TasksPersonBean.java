package com.nestorrojas07.springrest.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nestorrojas07.springrest.repository.IPersonaRepository;


@Component
public class TasksPersonBean {
	
	@Autowired
	private IPersonaRepository ps;

	@Scheduled(cron = "${spring.blacksip.cron.procesarPersona}")
	public void procesarPersona() {
		System.out.println("Ejecutando procesarPersona");
		ps.marcarProcesado(true);
		
	}
	
}
