package com.turismogta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismogta.entity.categoria;

@Repository
public interface categoriaRepository extends JpaRepository<categoria, Integer> {

Optional<categoria> findByNombreCategoria(String nombre);
	
	boolean existsByNombreCategoria(String nombre);
}
