package com.carloscorbalan.aad.practicaextra2.data.pojos;

public class Dispositivos {
	private int id_dispositivo;
	private String nombre;
	private String direccion_mac;
	private int id_red;
	private int tipo;
	public int getId_dispositivo() {
		return id_dispositivo;
	}
	public void setId_dispositivo(int id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion_mac() {
		return direccion_mac;
	}
	public void setDireccion_mac(String direccion_mac) {
		this.direccion_mac = direccion_mac;
	}
	public int getId_red() {
		return id_red;
	}
	public void setId_red(int id_red) {
		this.id_red = id_red;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
