package com.turismogta.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class planTuristico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlan;
	
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
	
	public planTuristico() {
		super();
	}


	

	public planTuristico(String nombrePlan, String descripcionPlan, @Min(0) float precioPlan, Date fechaInicio,
			Date fechaFin, boolean estadoPlan) {
		super();
		this.nombrePlan = nombrePlan;
		this.descripcionPlan = descripcionPlan;
		this.precioPlan = precioPlan;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estadoPlan = estadoPlan;
	}




	public int getIdPlan() {
		return idPlan;
	}


	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
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
	
	
	
	
	
	
}
