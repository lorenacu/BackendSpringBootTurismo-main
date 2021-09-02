package com.turismogta.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismogta.entity.audio;
import com.turismogta.repository.audioRepository;

@Service
@Transactional
public class audioService {

	@Autowired
	audioRepository audioRepository;
	
	
	public void save(audio audio) {  //para guardar
		audioRepository.save(audio);
	}
	
	public Optional<audio> getIdAudio(int idAtractivo) {    //optiene un elemento por id
		return audioRepository.findByIdAudio(idAtractivo);
	}
	
	/*public boolean existsById(int idAtractivo) {							//devuelve verdadero si existe
		return audioRepository.existsByIdAtractivo(idAtractivo);
		
	}*/
}
