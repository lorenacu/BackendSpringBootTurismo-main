package com.turismogta.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class audio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idAudio;
	String nombreAudio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	Date fechaAudio;
	
	@Lob
	String ubicacionAudio;
	
	
	
	@OneToOne(mappedBy = "audio")
    private atractivoTuristico atractivoTuristico;

	public audio() {
		super();
	}

	


	


	public audio(String nombreAudio, Date fechaAudio, String ubicacionAudio,
			com.turismogta.entity.atractivoTuristico atractivoTuristico) {
		super();
		this.nombreAudio = nombreAudio;
		this.fechaAudio = fechaAudio;
		this.ubicacionAudio = ubicacionAudio;
		this.atractivoTuristico = atractivoTuristico;
	}







	public int getIdAudio() {
		return idAudio;
	}







	public void setIdAudio(int idAudio) {
		this.idAudio = idAudio;
	}







	public String getNombreAudio() {
		return nombreAudio;
	}







	public void setNombreAudio(String nombreAudio) {
		this.nombreAudio = nombreAudio;
	}







	public Date getFechaAudio() {
		return fechaAudio;
	}







	public void setFechaAudio(Date fechaAudio) {
		this.fechaAudio = fechaAudio;
	}







	public String getUbicacionAudio() {
		return ubicacionAudio;
	}







	public void setUbicacionAudio(String ubicacionAudio) {
		this.ubicacionAudio = ubicacionAudio;
	}







	public atractivoTuristico getAtractivoTuristico() {
		return atractivoTuristico;
	}







	public void setAtractivoTuristico(atractivoTuristico atractivoTuristico) {
		this.atractivoTuristico = atractivoTuristico;
	}




	
	
}
