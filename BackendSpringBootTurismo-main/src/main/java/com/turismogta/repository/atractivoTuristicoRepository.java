package com.turismogta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turismogta.entity.atractivoTuristico;

@Repository
public interface atractivoTuristicoRepository extends JpaRepository<atractivoTuristico, Integer>{
	
	@Query(value = "select * from atractivo inner join (tiene inner join categoria on tiene.id_categoria = categoria.id_categoria) on atractivo.id_atractivo=tiene.id_atractivo", nativeQuery = true)
	  List<atractivoTuristico> allAtCa();
	
	
	Optional<atractivoTuristico> findByNombreAtractivo(String nombre);
	
	
	/*@Query("select * from atractivo where nombre_atractivo = ?1")
	  atractivoTuristico findByNombreAtractivoOutId(String nombre);*/
	
	boolean existsByNombreAtractivo(String nombre);
	
}
