package com.nestorrojas07.springrest.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nestorrojas07.springrest.model.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Long>{

	 @Procedure(name = "GUARDARPERSONA")
	    Long savePersonaStoreProcedure(
	    		  @Param("nombre") String inNombre,
	    		  @Param("apellido") String inApellido,
	    		  @Param("procesado") Byte inProcesado
	    		);
	 
	 
	 @Modifying(clearAutomatically = true)
	 @Query("UPDATE Persona p SET p.procesado = :isProcesado where p.procesado = false")
	 @Transactional
	 void marcarProcesado(@Param("isProcesado") Boolean isProcesado);
}
