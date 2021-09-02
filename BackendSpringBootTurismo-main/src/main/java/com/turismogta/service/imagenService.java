package com.turismogta.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismogta.entity.imagen;
import com.turismogta.repository.imagenRepository;

@Service
@Transactional
public class imagenService {
	
	@Autowired
	imagenRepository imagenRepository;
	
	public List<imagen> list(){
		return imagenRepository.findAll();		//obtiene todos los elementso de la tabla
	}
	
	
	public List<imagen> listIdAtractivo(int idAtractivo){
		return imagenRepository.findAllByIdAtractivo(idAtractivo);		//obtiene todos los elementso de la tabla
	}
	
	public List<imagen> listIdPlan(int idPlan){
		return imagenRepository.findAllByIdPlan(idPlan);		//obtiene todos los elementso de la tabla
	}
	
	public Optional<imagen> getOne(int id) {    //optiene un elemento por id
		return imagenRepository.findById(id);
	}
	
	public Optional<imagen> getByNombre(String nombre) {  //debuelve un elemento buscado por nombre
		return imagenRepository.findByNombreImagen(nombre);
	}
	
	public void save(imagen imagen) {  //para guardar
		imagenRepository.save(imagen);
	}
	
	public imagen  saveFoto(imagen imagenRequest)
    {
       return imagenRepository.save(imagenRequest);
    }
	
	public void delete(int id) {								//borrar un elemento por id
		imagenRepository.deleteById(id);
		
	}
	
	public boolean existsById(int id) {							//devuelve verdadero si existe
		return imagenRepository.existsById(id);
		
	}
	
	public boolean existsByNombre(String nombreImagen) {							//devuelve verdadero si existe
		return imagenRepository.existsByNombreImagen(nombreImagen);
		
	}
	
	
	
}
