package com.turismogta.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismogta.entity.atractivoTuristico;
import com.turismogta.repository.atractivoTuristicoRepository;

@Service
@Transactional
public class atractivoTuristicoService {
	
	@Autowired
	atractivoTuristicoRepository atractivoTuristicoRepository;
	
	public List<atractivoTuristico> list(){
		return atractivoTuristicoRepository.findAll();		//obtiene todos los elementso de la tabla
	}
	
	public List<atractivoTuristico> listAtCt(){
		return atractivoTuristicoRepository.allAtCa();		//obtiene todos los elementso de la tabla
	}
	
	public Optional<atractivoTuristico> getOne(int id) {    //optiene un elemento por id
		return atractivoTuristicoRepository.findById(id);
	}
	
	public Optional<atractivoTuristico> getByNombre(String nombre) {  //debuelve un elemento buscado por nombre
		return atractivoTuristicoRepository.findByNombreAtractivo(nombre);
	}
	
	
	/*public atractivoTuristico getByNombreOutId(String nombre) {  //debuelve un elemento buscado por nombre
		return atractivoTuristicoRepository.findByNombreAtractivoOutId(nombre);
	}*/
	
	public void save(atractivoTuristico atractivoTuristico) {  //para guardar
		atractivoTuristicoRepository.save(atractivoTuristico);
	}
	
	public void delete(int id) {								//borrar un elemento por id
		atractivoTuristicoRepository.deleteById(id);
		
	}
	
	public boolean existsById(int id) {							//devuelve verdadero si existe
		return atractivoTuristicoRepository.existsById(id);
		
	}
	
	public boolean existsByNombre(String nombreAtractivo) {							//devuelve verdadero si existe
		return atractivoTuristicoRepository.existsByNombreAtractivo(nombreAtractivo);
		
	}
	
	
}
