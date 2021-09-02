package com.turismogta.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import antlr.collections.List;

@Entity
public class imagen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdImagen;
	
	private String nombreImagen;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Date fechaImagen;
	
	
	@Lob
	private String ubicacionImagen;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_atractivo",updatable = true)
	private atractivoTuristico atractivoTuristico;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_plan",updatable = true)
	private planTuristico planTuristico;
	
	public imagen() {
		super();
	}


	


	public imagen(String nombreImagen, Date fechaImagen, String ubicacionImagen,
			com.turismogta.entity.atractivoTuristico atractivoTuristico,
			com.turismogta.entity.planTuristico planTuristico) {
		super();
		this.nombreImagen = nombreImagen;
		this.fechaImagen = fechaImagen;
		this.ubicacionImagen = ubicacionImagen;
		this.atractivoTuristico = atractivoTuristico;
		this.planTuristico = planTuristico;
	}





	public int getIdImagen() {
		return IdImagen;
	}


	public void setIdImagen(int idImagen) {
		IdImagen = idImagen;
	}


	public String getNombreImagen() {
		return nombreImagen;
	}


	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}


	public Date getFechaImagen() {
		return fechaImagen;
	}


	public void setFechaImagen(Date fechaImagen) {
		this.fechaImagen = fechaImagen;
	}


	public String getUbicacionImagen() {
		return ubicacionImagen;
	}


	public void setUbicacionImagen(String ubicacionImagen) {
		this.ubicacionImagen = ubicacionImagen;
	}


	public atractivoTuristico getAtractivoTuristico() {
		return atractivoTuristico;
	}


	public void setAtractivoTuristico(atractivoTuristico atractivoTuristico) {
		this.atractivoTuristico = atractivoTuristico;
	}





	public planTuristico getPlanTuristico() {
		return planTuristico;
	}





	public void setPlanTuristico(planTuristico planTuristico) {
		this.planTuristico = planTuristico;
	}

	
	
	
}
