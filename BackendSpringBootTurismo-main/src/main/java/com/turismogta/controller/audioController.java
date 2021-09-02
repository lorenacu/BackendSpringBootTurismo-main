package com.turismogta.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismogta.dto.mensaje;
import com.turismogta.entity.atractivoTuristico;
import com.turismogta.entity.audio;
import com.turismogta.entity.imagen;
import com.turismogta.repository.atractivoTuristicoRepository;
import com.turismogta.service.atractivoTuristicoService;
import com.turismogta.service.audioService;

@RestController
@RequestMapping("/audio")
@CrossOrigin(origins = "*") //aqui el puerto de angular http://localhost:4200
public class audioController {

	@Autowired
	atractivoTuristicoService atractivoTuristicoService;
	
	@Autowired
	atractivoTuristicoRepository atractivoTuristicoRepository;
	
	@Autowired
	audioService audioService;
	
	@PostMapping("/{idAtractivo}/crear")
	public ResponseEntity<?> create(@PathVariable int idAtractivo,
			@RequestBody audio audio){
		
		if(!atractivoTuristicoService.existsById(idAtractivo) )
			return new ResponseEntity(new mensaje("No se encuentran los datos del atractivo turistico"), HttpStatus.NOT_FOUND);
		
		atractivoTuristico atractivoTuristico = atractivoTuristicoRepository.findById(idAtractivo).get();
		
				
				LocalDateTime localDateTime = LocalDateTime.now();
				Date date2 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
				
				
				audio.getNombreAudio();
				audio.setFechaAudio(date2);
				audio.getUbicacionAudio();

				atractivoTuristico.setAudio(audio);
			
				audioService.save(audio);
			
		return new ResponseEntity(new mensaje("Subida con exito"),HttpStatus.OK);
		
	}
	
	
	@PostMapping("/crear")
	public ResponseEntity<?> createSin(
			@RequestBody audio audio){
		
		
				
				LocalDateTime localDateTime = LocalDateTime.now();
				Date date2 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
				
				
				audio.getNombreAudio();
				audio.setFechaAudio(date2);
				audio.getUbicacionAudio();

			
				audioService.save(audio);
			
		return new ResponseEntity(new mensaje("Subida con exito"),HttpStatus.OK);
		
	}
	
	@GetMapping("/detalle/{idAtractivo}")
	public ResponseEntity<imagen> getById(@PathVariable("idAtractivo") int idAtractivo) {
		/*if(!audioService.existsById(idAtractivo)) 
			return new ResponseEntity(new mensaje("El audio no existe"), HttpStatus.NOT_FOUND);*/
		audio audio = audioService.getIdAudio(idAtractivo).get();
		return new ResponseEntity(audio, HttpStatus.OK);
	}
}
