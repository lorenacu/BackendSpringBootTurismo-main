package com.turismogta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turismogta.entity.imagen;

@Repository
public interface imagenRepository extends JpaRepository<imagen, Integer>{
	
	Optional<imagen> findByNombreImagen(String nombre);
	
	boolean existsByNombreImagen(String nombre);
	
	@Query(value = "select * from imagen where id_atractivo = ?1", nativeQuery = true)
	  List<imagen> findAllByIdAtractivo(int idAtractivo);
	
	  
	@Query(value = "select * from imagen where id_plan = ?1", nativeQuery = true)
	List<imagen> findAllByIdPlan(int idPlan);
	
}
