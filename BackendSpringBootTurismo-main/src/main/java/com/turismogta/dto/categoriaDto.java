package com.turismogta.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class categoriaDto {
	
	@NotBlank
	@Column(length = 30)
	private String nombreCategoria;
	private String descripcionCategoria;
	public categoriaDto() {
		super();
	}
	public categoriaDto(@NotBlank String nombreCategoria,String descripcionCategoria) {
		super();
		this.nombreCategoria = nombreCategoria;
		this.descripcionCategoria = descripcionCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}
	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}
	
	
}
