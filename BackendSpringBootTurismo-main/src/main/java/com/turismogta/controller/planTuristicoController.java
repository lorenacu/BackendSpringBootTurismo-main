package com.turismogta.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismogta.dto.mensaje;
import com.turismogta.dto.planTuristicoDto;
import com.turismogta.entity.planTuristico;
import com.turismogta.service.planTuristicoService;

@RestController
@RequestMapping("/plan_turistico")
@CrossOrigin(origins = "*") //aqui el puerto de angular http://localhost:4200
public class planTuristicoController {

	@Autowired
	planTuristicoService planTuristicoService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<planTuristico>> list() {
		List<planTuristico> list = planTuristicoService.list();
		return new ResponseEntity<List<planTuristico>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody planTuristicoDto planTuristicoDto){
		
		if(StringUtils.isBlank(planTuristicoDto.getNombrePlan()))
			return new ResponseEntity(new mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(planTuristicoDto.getDescripcionPlan()))
			return new ResponseEntity(new mensaje("La descripcion es obligatoria"),HttpStatus.BAD_REQUEST);
		
		if(planTuristicoService.existsByNombre(planTuristicoDto.getNombrePlan()))
			return new ResponseEntity(new mensaje("El nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		
		/*LocalDateTime localDateTime = LocalDateTime.now();
		Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());*/
		
		planTuristico planTuristico = new planTuristico(
				planTuristicoDto.getNombrePlan(),
				planTuristicoDto.getDescripcionPlan(),
				planTuristicoDto.getPrecioPlan(),
				planTuristicoDto.getFechaInicio(),
				planTuristicoDto.getFechaFin(),
				planTuristicoDto.isEstadoPlan()
				);
	planTuristicoService.save(planTuristico);
	
	
	return new ResponseEntity(new mensaje("Plan turistico agregado correctamente"),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if(!planTuristicoService.existsById(id)) 
			return new ResponseEntity(new mensaje("El plan turístico no existe"), HttpStatus.NOT_FOUND);
		planTuristicoService.delete(id);
		return new ResponseEntity(new mensaje("Eliminado correctamente"),HttpStatus.OK);
		
	}
	
	
}
