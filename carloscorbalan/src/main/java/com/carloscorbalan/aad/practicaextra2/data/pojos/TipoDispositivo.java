package com.carloscorbalan.aad.practicaextra2.data.pojos;

import java.util.Collection;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@NamedQuery(
		name="masLogs",
		query="select t from "
				+ "TipoDispositivo t join Dispositivos  d on t = d.tipo "
				+ "join Logs l on l.dispositivo = d group by d.tipo order by count(t) desc limit 1"
	)
@Table(name="TipoDispositivo")
public class TipoDispositivo implements Pojo{
	@Id
	@Column(name="id_tipo_dispositivo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_tipo_dispositivo;
	@Column(name="nombre")
	private String nombre;
	@OneToMany(mappedBy="tipo")
	private Collection<Dispositivos> dispositivos;
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
