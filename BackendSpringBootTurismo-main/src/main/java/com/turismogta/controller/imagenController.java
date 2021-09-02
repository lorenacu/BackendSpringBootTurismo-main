package com.turismogta.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.turismogta.dto.mensaje;
import com.turismogta.entity.atractivoTuristico;
import com.turismogta.entity.imagen;
import com.turismogta.entity.planTuristico;
import com.turismogta.repository.atractivoTuristicoRepository;
import com.turismogta.repository.planTuristicoRepository;
import com.turismogta.service.atractivoTuristicoService;
import com.turismogta.service.imagenService;
import com.turismogta.service.planTuristicoService;


@RestController
@RequestMapping("/imagen")
@CrossOrigin(origins = "*") //aqui el puerto de angular http://localhost:4200
public class imagenController {
	
	@Autowired
	imagenService imagenService;
	
	@Autowired
	atractivoTuristicoRepository atractivoTuristicoRepository;
	
	@Autowired
	atractivoTuristicoService atractivoTuristicoService;
	
	@Autowired
	planTuristicoRepository planTuristicoRepository;
	
	@Autowired
	planTuristicoService planTuristicoService;
	
	
	
	
	@GetMapping("/lista")
	public ResponseEntity<List<imagen>> list() {
		List<imagen> list = imagenService.list();
		return new ResponseEntity<List<imagen>>(list, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/lista/{idAtractivo}")
	public ResponseEntity<List<imagen>> listIdAtractivo(@PathVariable("idAtractivo") int idAtractivo) {
		List<imagen> list = imagenService.listIdAtractivo(idAtractivo);
		return new ResponseEntity<List<imagen>>(list, HttpStatus.OK);
		
	}
	@GetMapping("/lista_img_plan/{idPlan}")
	public ResponseEntity<List<imagen>> listIdPlan(@PathVariable("idPlan") int idPlan) {
		List<imagen> list = imagenService.listIdPlan(idPlan);
		return new ResponseEntity<List<imagen>>(list, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<imagen> getById(@PathVariable("id") int id) {
		if(!imagenService.existsById(id)) 
			return new ResponseEntity(new mensaje("La imagen no existe"), HttpStatus.NOT_FOUND);
		imagen imagen = imagenService.getOne(id).get();
		return new ResponseEntity(imagen, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/name/{nombre}")
	public ResponseEntity<imagen> getByNombre(@PathVariable("nombre") String nombre) {
		if(!imagenService.existsByNombre(nombre)) 
			return new ResponseEntity(new mensaje("La imagen no existe"), HttpStatus.NOT_FOUND);
		imagen imagen = imagenService.getByNombre(nombre).get();
		return new ResponseEntity(imagen, HttpStatus.OK);
	}
	
	@PostMapping("/{idAtractivo}/crear")
	public ResponseEntity<?> create(@PathVariable int idAtractivo,
			@RequestBody imagen imagen){
		
		if(!atractivoTuristicoService.existsById(idAtractivo) )
			return new ResponseEntity(new mensaje("No se encuentran los datos del atractivo turistico"), HttpStatus.NOT_FOUND);
		
		atractivoTuristico atractivoTuristico = atractivoTuristicoRepository.findById(idAtractivo).get();
		
				
				LocalDateTime localDateTime = LocalDateTime.now();
				Date date2 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
				
				
				imagen.getNombreImagen();
				imagen.setFechaImagen(date2);
				imagen.getUbicacionImagen();
				imagen.setAtractivoTuristico(atractivoTuristico);
			
				imagenService.save(imagen);
			
		return new ResponseEntity(new mensaje("Subida con exito"),HttpStatus.OK);
		
	}
	
	
	@PostMapping("/imagen_a_plan/{idPlan}")
	public ResponseEntity<?> createplan(@PathVariable int idPlan,
			@RequestBody imagen imagen){
		
		if(!planTuristicoService.existsById(idPlan) )
			return new ResponseEntity(new mensaje("No se encuentran los datos del plan turístico"), HttpStatus.NOT_FOUND);
		
		planTuristico planTuristico = planTuristicoRepository.findById(idPlan).get();
		
				
				LocalDateTime localDateTime = LocalDateTime.now();
				Date date2 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
				
				
				imagen.getNombreImagen();
				imagen.setFechaImagen(date2);
				imagen.getUbicacionImagen();
				imagen.setPlanTuristico(planTuristico);
			
				imagenService.save(imagen);
			
		return new ResponseEntity(new mensaje("Subida con exito"),HttpStatus.OK);
		
	}
	
	/*@PostMapping("/create")
	public ResponseEntity<imagen> saveFoto( @Valid @RequestBody imagen fotoRequest)
	{
	    return new ResponseEntity<>(imagenService.saveFoto(fotoRequest), HttpStatus.OK);
	}*/
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if(!imagenService.existsById(id)) 
			return new ResponseEntity(new mensaje("La imagen no existe"), HttpStatus.NOT_FOUND);
		imagenService.delete(id);
		return new ResponseEntity(new mensaje("Eliminado correctamente"),HttpStatus.OK);
		
	}
	
}
