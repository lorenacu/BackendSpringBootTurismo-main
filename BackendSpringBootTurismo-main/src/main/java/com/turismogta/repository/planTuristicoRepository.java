package com.turismogta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismogta.entity.planTuristico;

@Repository
public interface planTuristicoRepository extends JpaRepository<planTuristico, Integer> {

	boolean existsByNombrePlan(String nombre);
}
