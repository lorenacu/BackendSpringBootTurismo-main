package com.turismogta.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class codigoQrDto {

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Date fechaQr;
	private String token;
	private String ubicacionQr;
	public codigoQrDto(Date fechaQr, String token, String ubicacionQr) {
		super();
		this.fechaQr = fechaQr;
		this.token = token;
		this.ubicacionQr = ubicacionQr;
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
	
	
	
}
