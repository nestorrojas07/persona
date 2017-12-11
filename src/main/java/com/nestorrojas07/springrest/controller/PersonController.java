package com.nestorrojas07.springrest.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.nestorrojas07.springrest.model.Persona;
import com.nestorrojas07.springrest.repository.IPersonaRepository;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	IPersonaRepository ps;
	
	@PersistenceContext
    private EntityManager manager;
	
	
	@RequestMapping(value= "/persons", method= RequestMethod.GET)
	public  Page<Persona> getAll(Pageable pages)
	{
		return ps.findAll(pages);
	}
	
	

	@RequestMapping(value= "/persons/processed", method= RequestMethod.GET)
	public  Page<Persona> getAllProcessed(Pageable pages)
	{
		return ps.findByProcesado(true, pages);
	}
	
	
	@RequestMapping(value = "persons/{id}")
	public ResponseEntity<Persona> getPerson(@PathVariable("id") long id)
	{
		Persona per = ps.findOne(id);
		if(per == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(per);
	}
	
	@PostMapping("/persons")
    public ResponseEntity<Persona> createNote(@Valid @RequestBody Persona persona) {
		try {
			
			System.out.println("persona to save "+persona.toString());
			Byte procesado = new Byte((byte)(persona.isProcesado() ? 1:0));
			Long id= ps.savePersonaStoreProcedure(persona.getNombre(), persona.getApellido(),procesado);
			Persona per = ps.findOne(id);
			if(per == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(per);
		}catch (Exception e) {
			System.out.println("Se genero un error al crear persona ");
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);//ps.save(persona);
        
    }
}
