package com.turismogta.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="categoria")
public class categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;
	private String nombreCategoria;
	private String descripcionCategoria;
	
	
	@ManyToMany
    @JoinTable(
            name = "tiene",
            joinColumns = @JoinColumn(name = "id_categoria",updatable = true),
            inverseJoinColumns = @JoinColumn(name = "id_atractivo",updatable = true)
    )
	public
    Set<atractivoTuristico> tiene = new HashSet<>();
	
	public categoria() {
		super();
	}



	public categoria( String nombreCategoria, String descripcionCategoria) {
		super();
		
		this.nombreCategoria = nombreCategoria;
		this.descripcionCategoria = descripcionCategoria;
	}



	public int getIdCategoria() {
		return idCategoria;
	}



	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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



	public Set<atractivoTuristico> getTiene() {
		return tiene;
	}



	public void setTiene(Set<atractivoTuristico> tiene) {
		this.tiene = tiene;
	}



	
	


	
	
}
