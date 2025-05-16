package com.carloscorbalan.aad.practicaextra2.data.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
@Entity
public class TipoDispositivo {
	@Id
	private int id_tipo_dispositivo;
	@NotNull
	private String nombre;
	public int getId_tipo_dispositivo() {
		return id_tipo_dispositivo;
	}
	public void setId_tipo_dispositivo(int id_tipo_dispositivo) {
		this.id_tipo_dispositivo = id_tipo_dispositivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
