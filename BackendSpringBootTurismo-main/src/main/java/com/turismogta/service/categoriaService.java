package com.turismogta.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismogta.repository.categoriaRepository;
import com.turismogta.entity.*;



@Service
@Transactional
public class categoriaService {
	@Autowired
	categoriaRepository categoriaRepository;
	
	public List<categoria> list() {
		return categoriaRepository.findAll();
	}
	
	public Optional<categoria> getByNombreCategoria(String nombre) {
		return categoriaRepository.findByNombreCategoria(nombre);
	}
	
	public Optional<categoria> getOne(int id) {
		return categoriaRepository.findById(id);
	}
	
	public void save(categoria cat) {
		categoriaRepository.save(cat);			///para guadar la categoria
	}
	
	public void delete(int id) {
		categoriaRepository.deleteById(id);
	}
	
	public boolean existById(int id) {
		return categoriaRepository.existsById(id);
	}
	 public boolean existByNombreCategoria(String nombre) {
		return categoriaRepository.existsByNombreCategoria(nombre);
	}
}
