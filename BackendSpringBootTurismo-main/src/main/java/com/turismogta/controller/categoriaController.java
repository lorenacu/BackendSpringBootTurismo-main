package com.turismogta.controller;

import java.util.List;

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
import org.apache.commons.lang3.StringUtils;
import com.turismogta.dto.categoriaDto;
import com.turismogta.dto.mensaje;
import com.turismogta.entity.*;
import com.turismogta.service.categoriaService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class categoriaController {
	
	@Autowired
	categoriaService categoriaService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<categoria>> list(){
		List<categoria> list = categoriaService.list();
		return new ResponseEntity<List<categoria>>(list,HttpStatus.OK);
	}

	//buscar por id
	@GetMapping("/detalle/{id}")												
	public ResponseEntity<categoria> getById(@PathVariable("id") int id){
		if (!categoriaService.existById(id)) 
			return new ResponseEntity(new mensaje("No se encuentra la categoria buscada"), HttpStatus.NOT_FOUND);
		categoria categoria = categoriaService.getOne(id).get();
		return new ResponseEntity(categoria,HttpStatus.OK);
			
	}
	
	
	//buscar por nombre
	@GetMapping("/detalle/{nombre}")
	public ResponseEntity<categoria> getByNomrbe(@PathVariable("nombre") String nombre){
		if (!categoriaService.existByNombreCategoria(nombre)) 
			return new ResponseEntity(new mensaje("No se encuentra la categoria buscada"), HttpStatus.NOT_FOUND);
		categoria categoria = categoriaService.getByNombreCategoria(nombre).get();
		return new ResponseEntity(categoria,HttpStatus.OK);
			
	}
	
	//pare agregar una nueva categoria
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody categoriaDto categoriaDto){
		if(StringUtils.isBlank(categoriaDto.getNombreCategoria()))
			return new ResponseEntity(new mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(categoriaDto.getDescripcionCategoria()))
			return new ResponseEntity(new mensaje("La descripcion es obligatoria"),HttpStatus.BAD_REQUEST);
		
		if(categoriaService.existByNombreCategoria(categoriaDto.getNombreCategoria()))
			return new ResponseEntity(new mensaje("El nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		
		categoria categoria = new categoria(
				categoriaDto.getNombreCategoria(),
				categoriaDto.getDescripcionCategoria()
				);
		
	categoriaService.save(categoria);
	return new ResponseEntity(new mensaje("Categoria turistico agregada correctamente"),HttpStatus.OK);
	}
	
	
	
	
	//para actualizar una categoria
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody categoriaDto categoriaDto){
		if(!categoriaService.existById(id)) 
			return new ResponseEntity(new mensaje("La categoria no existe"), HttpStatus.NOT_FOUND);
		
		if(categoriaService.existByNombreCategoria(categoriaDto.getNombreCategoria()) && categoriaService.getByNombreCategoria(categoriaDto.getNombreCategoria()).get().getIdCategoria()!= id)
			return new ResponseEntity(new mensaje("El nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(categoriaDto.getNombreCategoria()))
			return new ResponseEntity(new mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
		
		categoria categoria = categoriaService.getOne(id).get();
		categoria.setNombreCategoria(categoriaDto.getNombreCategoria());
		categoria.setDescripcionCategoria(categoriaDto.getDescripcionCategoria());
		
	categoriaService.save(categoria);
	
	return new ResponseEntity(new mensaje("Categoria agregado correctamente"),HttpStatus.OK);
	}
	
	//para borrar una categoria
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if(!categoriaService.existById(id)) 
			return new ResponseEntity(new mensaje("La categoria no existe"), HttpStatus.NOT_FOUND);
		categoriaService.delete(id);
		return new ResponseEntity(new mensaje("Eliminado correctamente"),HttpStatus.OK);
		
	}
	
}
