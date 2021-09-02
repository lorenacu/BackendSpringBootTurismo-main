package com.turismogta.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismogta.entity.codigoQr;
import com.turismogta.repository.codigoQrRepository;

@Service
@Transactional
public class codigoQrService {
	
	@Autowired
	codigoQrRepository codigoQrRepository;
	
	public List<codigoQr> list() {
		return codigoQrRepository.findAll();
	}
	
	
	public Optional<codigoQr> getOne(int id) {
		return codigoQrRepository.findById(id);
	}
	
	public void save(codigoQr cqr) {
		codigoQrRepository.save(cqr);			///para guadar la categoria
	}
	
	public void delete(int id) {
		codigoQrRepository.deleteById(id);
	}
	
	public boolean existById(int id) {
		return codigoQrRepository.existsById(id);
	}

}
