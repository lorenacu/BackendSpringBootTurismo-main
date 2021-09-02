package com.turismogta.dto;

import java.util.Date;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class audioDto {
	
	@NotBlank
	String nombreAudio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	Date fechaAudio;
	
	@Lob
	String ubicacionAudio;

	public audioDto() {
		super();
	}

	public audioDto(@NotBlank String nombreAudio, Date fechaAudio, String ubicacionAudio) {
		super();
		this.nombreAudio = nombreAudio;
		this.fechaAudio = fechaAudio;
		this.ubicacionAudio = ubicacionAudio;
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
	
	
}
