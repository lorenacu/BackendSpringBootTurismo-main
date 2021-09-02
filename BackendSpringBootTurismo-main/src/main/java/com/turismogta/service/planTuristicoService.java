package com.turismogta.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismogta.entity.planTuristico;
import com.turismogta.repository.planTuristicoRepository;

@Service
@Transactional
public class planTuristicoService {
	
	@Autowired
	planTuristicoRepository planTuristicoRepository;
	
	public List<planTuristico> list(){
		return planTuristicoRepository.findAll();		//obtiene todos los elementso de la tabla
	}
	public void save(planTuristico planTuristico) {  //para guardar
		planTuristicoRepository.save(planTuristico);
	}

	public boolean existsByNombre(String nombrePlan) {							//devuelve verdadero si existe
		return planTuristicoRepository.existsByNombrePlan(nombrePlan);
		
	}
	public void delete(int id) {								//borrar un elemento por id
		planTuristicoRepository.deleteById(id);
		
	}
	public boolean existsById(int id) {							//devuelve verdadero si existe
		return planTuristicoRepository.existsById(id);
		
	}
	
}
