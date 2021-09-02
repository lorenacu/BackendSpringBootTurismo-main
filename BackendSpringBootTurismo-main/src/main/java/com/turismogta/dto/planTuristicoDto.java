package com.turismogta.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.turismogta.entity.imagen;

public class planTuristicoDto {
	
	private String nombrePlan;
	private String descripcionPlan;
	@Min(value = 0)
	private float precioPlan;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-5")
	private Date fechaInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-5")
	private Date fechaFin;
	
	private boolean estadoPlan;
	
	
	@OneToMany(mappedBy = "planTuristico",cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<imagen> imagenlist;
	
	
	public planTuristicoDto() {
		super();
	}


	

	public planTuristicoDto(String nombrePlan, String descripcionPlan, @Min(0) float precioPlan, Date fechaInicio,
			Date fechaFin, boolean estadoPlan, List<imagen> imagenlist) {
		super();
		this.nombrePlan = nombrePlan;
		this.descripcionPlan = descripcionPlan;
		this.precioPlan = precioPlan;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estadoPlan = estadoPlan;
		this.imagenlist = imagenlist;
	}











	public String getNombrePlan() {
		return nombrePlan;
	}


	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}


	public String getDescripcionPlan() {
		return descripcionPlan;
	}


	public void setDescripcionPlan(String descripcionPlan) {
		this.descripcionPlan = descripcionPlan;
	}


	public float getPrecioPlan() {
		return precioPlan;
	}


	public void setPrecioPlan(float precioPlan) {
		this.precioPlan = precioPlan;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}





	public boolean isEstadoPlan() {
		return estadoPlan;
	}





	public void setEstadoPlan(boolean estadoPlan) {
		this.estadoPlan = estadoPlan;
	}




	public List<imagen> getImagenlist() {
		return imagenlist;
	}




	public void setImagenlist(List<imagen> imagenlist) {
		this.imagenlist = imagenlist;
	}
	
	
	
	
	
}
