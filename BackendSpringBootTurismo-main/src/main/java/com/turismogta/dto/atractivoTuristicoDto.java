package com.turismogta.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.turismogta.entity.audio;
import com.turismogta.entity.categoria;
import com.turismogta.entity.codigoQr;
import com.turismogta.entity.imagen;

public class atractivoTuristicoDto {
	
	@NotBlank
	@Column(length=30)
	private String nombreAtractivo;
	@NotBlank
	private String descripcionAtractivo;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Date fechaRegistro;
	@Min(0)
	private float cantidadVistas;
	private boolean estadoAtractivo;
	
	
	@OneToMany(mappedBy = "atractivoTuristico")
	private List<imagen> imagenlist;
	
	@JsonIgnore
    @ManyToMany(mappedBy = "tiene")
    private Set<categoria> categoria = new HashSet<>();
    
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_qr", referencedColumnName = "idQr", updatable = true)
    private codigoQr codigoQr;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_audio", referencedColumnName = "idAudio", updatable = true)
    private audio audio;

	
	public atractivoTuristicoDto() {
		super();
	}


	
	public atractivoTuristicoDto(@NotBlank String nombreAtractivo, @NotBlank String descripcionAtractivo,
			 @Min(0) float cantidadVistas, boolean estadoAtractivo, List<imagen> imagenlist,
			 com.turismogta.entity.codigoQr codigoQr,
			com.turismogta.entity.audio audio) {
		super();
		this.nombreAtractivo = nombreAtractivo;
		this.descripcionAtractivo = descripcionAtractivo;
		this.cantidadVistas = cantidadVistas;
		this.estadoAtractivo = estadoAtractivo;
		this.imagenlist = imagenlist;
		this.codigoQr = codigoQr;
		this.audio = audio;
	}




	public String getNombreAtractivo() {
		return nombreAtractivo;
	}


	public void setNombreAtractivo(String nombreAtractivo) {
		this.nombreAtractivo = nombreAtractivo;
	}


	public String getDescripcionAtractivo() {
		return descripcionAtractivo;
	}


	public void setDescripcionAtractivo(String descripcionAtractivo) {
		this.descripcionAtractivo = descripcionAtractivo;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public float getCantidadVistas() {
		return cantidadVistas;
	}


	public void setCantidadVistas(float cantidadVistas) {
		this.cantidadVistas = cantidadVistas;
	}


	public boolean isEstadoAtractivo() {
		return estadoAtractivo;
	}


	public void setEstadoAtractivo(boolean estadoAtractivo) {
		this.estadoAtractivo = estadoAtractivo;
	}


	public List<imagen> getImagenlist() {
		return imagenlist;
	}


	public void setImagenlist(List<imagen> imagenlist) {
		this.imagenlist = imagenlist;
	}





	public audio getAudio() {
		return audio;
	}





	public void setAudio(audio audio) {
		this.audio = audio;
	}




	public codigoQr getCodigoQr() {
		return codigoQr;
	}



	public void setCodigoQr(codigoQr codigoQr) {
		this.codigoQr = codigoQr;
	}



	public Set<categoria> getCategoria() {
		return categoria;
	}



	public void setCategoria(Set<categoria> categoria) {
		this.categoria = categoria;
	}

	
	
	
}
