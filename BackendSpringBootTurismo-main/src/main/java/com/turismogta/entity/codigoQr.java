package com.turismogta.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class codigoQr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQr;
	private Date fechaQr;
	private String token;
	private String ubicacionQr;
	
	 
	 @OneToOne(mappedBy = "codigoQr")
	    private atractivoTuristico atractivoTuristico;


	public codigoQr() {
		super();
	}


	public codigoQr(Date fechaQr, String token, String ubicacionQr,
			com.turismogta.entity.atractivoTuristico atractivoTuristico) {
		super();
		this.fechaQr = fechaQr;
		this.token = token;
		this.ubicacionQr = ubicacionQr;
		this.atractivoTuristico = atractivoTuristico;
	}


	public Date getFechaQr() {
		return fechaQr;
	}


	public void setFechaQr(Date fechaQr) {
		this.fechaQr = fechaQr;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getUbicacionQr() {
		return ubicacionQr;
	}


	public void setUbicacionQr(String ubicacionQr) {
		this.ubicacionQr = ubicacionQr;
	}


	public atractivoTuristico getAtractivoTuristico() {
		return atractivoTuristico;
	}


	public void setAtractivoTuristico(atractivoTuristico atractivoTuristico) {
		this.atractivoTuristico = atractivoTuristico;
	}


	 
}
