package com.carloscorbalan.aad.practicaextra2.data.pojos;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name="Logs")
public class Logs implements Pojo{
	@Id
	@Column(name="id_log")
	private Integer id_log;
	@ManyToOne
	@JoinColumn(name="id_dispositivo",referencedColumnName="id_dispositivo")
	private Dispositivos dispositivo;
	@ManyToOne
	@JoinColumn(name="id_usuario",referencedColumnName="id_usuario")
	private Usuarios usuario;
	@Column(name="mensaje")
	private String mensaje;
	@Column(name="fecha")
	//omegalul
	@Temporal(TemporalType.DATE)
	private Date fecha;
	public int getId_log() {
		return id_log;
	}
	public void setId_log(int id_log) {
		this.id_log = id_log;
	}
	public Dispositivos get_dispositivo() {
		return dispositivo;
	}
	public void setId_dispositivo(Dispositivos id_dispositivo) {
		this.dispositivo = id_dispositivo;
	}
	public Usuarios getId_usuario() {
		return usuario;
	}
	public void setId_usuario(Usuarios id_usuario) {
		this.usuario = id_usuario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
