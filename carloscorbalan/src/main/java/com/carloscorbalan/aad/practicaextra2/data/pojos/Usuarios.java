package com.carloscorbalan.aad.practicaextra2.data.pojos;



import java.util.Collection;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@NamedQuery(
		name="infoUsuarios",
		query="select u.correo,count(l) as n, max(fecha),min(fecha) from Usuarios u "
				+ "join Logs l on u=l.usuario group by u.id_usuario "
				+ "order by n desc"
		)
@Table(name="Usuarios")
public class Usuarios implements Pojo{
	@Id
	@Column(name="id_usuario")
	private Integer id_usuario;
	@Column(name="nombre")
	private String nombre;
	@Column(name="correo")
	private String correo;
	@OneToMany(mappedBy="usuario")
	private Collection<Logs> logs;
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
