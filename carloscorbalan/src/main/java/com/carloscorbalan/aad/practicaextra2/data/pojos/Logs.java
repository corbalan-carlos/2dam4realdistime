package com.carloscorbalan.aad.practicaextra2.data.pojos;

import java.util.Date;

public class Logs {
	private int id_log;
	private int id_dispositivo;
	private int id_usuario;
	private String mensaje;
	private Date fecha;
	public int getId_log() {
		return id_log;
	}
	public void setId_log(int id_log) {
		this.id_log = id_log;
	}
	public int getId_dispositivo() {
		return id_dispositivo;
	}
	public void setId_dispositivo(int id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
