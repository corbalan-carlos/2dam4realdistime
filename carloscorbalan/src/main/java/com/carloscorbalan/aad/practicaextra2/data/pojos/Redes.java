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

@Entity
@NamedQuery(
		name="redUsada",
		query="select r from Redes r join Dispositivos d on r=d.id_red "
			+ "join Logs l on l.dispositivo=d join Usuarios u on l.usuario=u "
			+ "where r.id_red=:red and u.id_usuario=:u"
		)
@Table(name="Redes")
public class Redes  implements Pojo{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_red")
	private int id_red;
	@Column(name="nombre")
	private String nombre;
	@Column(name="direccion_ip")
	private String direccion_ip;
	@OneToMany(mappedBy ="id_dispositivo")
	private Collection<Dispositivos> dispositivos;
	public Collection<Dispositivos> getDispositivos() {
		return dispositivos;
	}
	public void setDispositivos(Collection<Dispositivos> dispositivos) {
		this.dispositivos = dispositivos;
	}
	public int getId_red() {
		return id_red;
	}
	public void setId_red(int id_red) {
		this.id_red = id_red;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion_ip() {
		return direccion_ip;
	}
	public void setDireccion_ip(String direccion_ip) {
		this.direccion_ip = direccion_ip;
	}


}
