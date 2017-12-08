package com.nestorrojas07.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.nestorrojas07.springrest.model.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Long>{

	 @Procedure(name = "GUARDARPERSONA")
	    Long savePersonaStoreProcedure(
	    		  @Param("nombre") String inNombre,
	    		  @Param("apellido") String inApellido,
	    		  @Param("procesado") Byte inProcesado
	    		);
}
