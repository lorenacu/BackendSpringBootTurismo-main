package com.turismogta.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismogta.dto.atractivoTuristicoDto;
import com.turismogta.dto.mensaje;
import com.turismogta.entity.atractivoTuristico;
import com.turismogta.entity.categoria;
import com.turismogta.repository.categoriaRepository;
import com.turismogta.service.atractivoTuristicoService;
import com.turismogta.service.categoriaService;
import com.turismogta.service.imagenService;

@RestController
@RequestMapping("/atractivo_turistico")
@CrossOrigin(origins = "*") //aqui el puerto de angular http://localhost:4200
public class atractivoTuristicoController {
	
	@Autowired
	atractivoTuristicoService atractivoTuristicoService;
	@Autowired
	imagenService imagenService;
	
	@Autowired
	categoriaRepository categoriaRepository;
	
	@Autowired
	categoriaService categoriaService;
	
	
	@GetMapping("/lista")
	public ResponseEntity<List<atractivoTuristico>> list() {
		List<atractivoTuristico> list = atractivoTuristicoService.list();
		return new ResponseEntity<List<atractivoTuristico>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/lista_atractivos")
	public ResponseEntity<List<atractivoTuristico>> listAtCt() {
		List<atractivoTuristico> list = atractivoTuristicoService.listAtCt();
		return new ResponseEntity<List<atractivoTuristico>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<atractivoTuristico> getById(@PathVariable("id") int id) {
		if(!atractivoTuristicoService.existsById(id)) 
			return new ResponseEntity(new mensaje("El atractivo turistico no existe"), HttpStatus.NOT_FOUND);
		atractivoTuristico atractivoTuristico = atractivoTuristicoService.getOne(id).get();
		return new ResponseEntity(atractivoTuristico, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/name/{nombre}")
	public ResponseEntity<atractivoTuristico> getByNombre(@PathVariable("nombre") String nombre) {
		if(!atractivoTuristicoService.existsByNombre(nombre)) 
			return new ResponseEntity(new mensaje("El atractivo turistico no existe"), HttpStatus.NOT_FOUND);
		atractivoTuristico atractivoTuristico = atractivoTuristicoService.getByNombre(nombre).get();
		return new ResponseEntity(atractivoTuristico, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody atractivoTuristicoDto atractivoTuristicoDto){
		if(StringUtils.isBlank(atractivoTuristicoDto.getNombreAtractivo()))
			return new ResponseEntity(new mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(atractivoTuristicoDto.getDescripcionAtractivo()))
			return new ResponseEntity(new mensaje("La descripcion es obligatoria"),HttpStatus.BAD_REQUEST);
		
		if(atractivoTuristicoService.existsByNombre(atractivoTuristicoDto.getNombreAtractivo()))
			return new ResponseEntity(new mensaje("El nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		atractivoTuristico atractivoTuristico = new atractivoTuristico(
				atractivoTuristicoDto.getNombreAtractivo(),
				atractivoTuristicoDto.getDescripcionAtractivo(),
				atractivoTuristicoDto.getCantidadVistas(),
				atractivoTuristicoDto.isEstadoAtractivo(),
				atractivoTuristicoDto.getImagenlist(),
				atractivoTuristicoDto.getCodigoQr(),
				atractivoTuristicoDto.getAudio()
				);
		atractivoTuristico.setFechaRegistro(date);
	atractivoTuristicoService.save(atractivoTuristico);
	
	
	return new ResponseEntity(new mensaje("Atractivo turistico agregado correctamente"),HttpStatus.OK);
	}
	
	
	//Para crear un atrctivo agregandole una categoria
	@PostMapping("/crear/{id_categoria}")
	public ResponseEntity<?> create(@PathVariable("id_categoria") int id_categoria,@RequestBody atractivoTuristicoDto atractivoTuristicoDto){
		
		if (!categoriaService.existById(id_categoria))
			return new ResponseEntity(new mensaje("No existe la categoria"), HttpStatus.NOT_ACCEPTABLE);
		
		if(StringUtils.isBlank(atractivoTuristicoDto.getNombreAtractivo()))
			return new ResponseEntity(new mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(atractivoTuristicoDto.getDescripcionAtractivo()))
			return new ResponseEntity(new mensaje("La descripcion es obligatoria"),HttpStatus.BAD_REQUEST);
		
		if(atractivoTuristicoService.existsByNombre(atractivoTuristicoDto.getNombreAtractivo()))
			return new ResponseEntity(new mensaje("El nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Date date2 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		categoria  categoria = categoriaRepository.findById(id_categoria).get();
		atractivoTuristico atractivoTuristico = new atractivoTuristico(
				atractivoTuristicoDto.getNombreAtractivo(),
				atractivoTuristicoDto.getDescripcionAtractivo(),
				atractivoTuristicoDto.getCantidadVistas(),
				atractivoTuristicoDto.isEstadoAtractivo(),
				atractivoTuristicoDto.getImagenlist(),
				atractivoTuristicoDto.getCodigoQr(),
				atractivoTuristicoDto.getAudio()
				
				);
		
		
		atractivoTuristico.setFechaRegistro(date2);
		
		//Subject subject = subjectRepository.findById(subjectId).get();
		
		categoria.tiene.add(atractivoTuristico);
	atractivoTuristicoService.save(atractivoTuristico);
	
	return new ResponseEntity(new mensaje("Atractivo turistico agregado correctamente"),HttpStatus.OK);
	}
	
	
	
	@PutMapping("/actualizar/{idAtractivo}/{idCategoria}")
	public ResponseEntity<?> update(
			@PathVariable("idAtractivo") int idAtractivo, 
			@PathVariable("idCategoria") int idCategoria, 
			@RequestBody atractivoTuristicoDto atractivoTuristicoDto){
		
		
		if(!atractivoTuristicoService.existsById(idAtractivo)) 
			return new ResponseEntity(new mensaje("El atractivo turistico no existe"), HttpStatus.NOT_FOUND);
		
		if(!categoriaService.existById(idCategoria)) 
			return new ResponseEntity(new mensaje("La categoria no existe"), HttpStatus.NOT_FOUND);
		
		if(atractivoTuristicoService.existsByNombre(atractivoTuristicoDto.getNombreAtractivo()) && atractivoTuristicoService.getByNombre(atractivoTuristicoDto.getNombreAtractivo()).get().getIdAtractivo()!= idAtractivo)
			return new ResponseEntity(new mensaje("El nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(atractivoTuristicoDto.getNombreAtractivo()))
			return new ResponseEntity(new mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(atractivoTuristicoDto.getDescripcionAtractivo()))
			return new ResponseEntity(new mensaje("La descripcion es obligatoria"),HttpStatus.BAD_REQUEST);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Date date2 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		atractivoTuristico atractivoTuristico = atractivoTuristicoService.getOne(idAtractivo).get();
		atractivoTuristico.setNombreAtractivo(atractivoTuristicoDto.getNombreAtractivo());
		atractivoTuristico.setDescripcionAtractivo(atractivoTuristicoDto.getDescripcionAtractivo());
		atractivoTuristico.setFechaRegistro(date2);
		atractivoTuristico.setCantidadVistas(atractivoTuristicoDto.getCantidadVistas());
		atractivoTuristico.setEstadoAtractivo(atractivoTuristicoDto.isEstadoAtractivo());
		
		categoria  categoria = categoriaRepository.findById(idCategoria).get();
		//categoria.setIdCategoria(idCategoria);
		categoria.tiene.add(atractivoTuristico);
		
	atractivoTuristicoService.save(atractivoTuristico);
	return new ResponseEntity(new mensaje("Atractivo turistico actualizado correctamente"),HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if(!atractivoTuristicoService.existsById(id)) 
			return new ResponseEntity(new mensaje("El atractivo turistico no existe"), HttpStatus.NOT_FOUND);
		atractivoTuristicoService.delete(id);
		return new ResponseEntity(new mensaje("Eliminado correctamente"),HttpStatus.OK);
		
	}
}
