package com.turismogta.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="atractivo")
public class atractivoTuristico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAtractivo;
	private String nombreAtractivo;
	private String descripcionAtractivo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Date fechaRegistro;
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


	public atractivoTuristico() {
		super();
	}









	public atractivoTuristico(String nombreAtractivo, String descripcionAtractivo, float cantidadVistas,
			boolean estadoAtractivo, List<imagen> imagenlist, com.turismogta.entity.codigoQr codigoQr,
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









	public int getIdAtractivo() {
		return idAtractivo;
	}









	public void setIdAtractivo(int idAtractivo) {
		this.idAtractivo = idAtractivo;
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









	public Set<categoria> getCategoria() {
		return categoria;
	}









	public void setCategoria(Set<categoria> categoria) {
		this.categoria = categoria;
	}









	public codigoQr getCodigoQr() {
		return codigoQr;
	}









	public void setCodigoQr(codigoQr codigoQr) {
		this.codigoQr = codigoQr;
	}









	public audio getAudio() {
		return audio;
	}









	public void setAudio(audio audio) {
		this.audio = audio;
	}





	
}
