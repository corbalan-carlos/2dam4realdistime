package com.carloscorbalan.aad.practicaextra2.data.pojos;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="Dispositivos")
public class Dispositivos implements Pojo{
	@Id
	@Column(name="id_dispositivo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_dispositivo;
	@Column(name="nombre")
	private String nombre;
	@Column(name="direccion_mac")
	private String direccion_mac;
	@ManyToOne
	@JoinColumn(name="id_red", referencedColumnName="id_red")
	private Redes id_red;
	@ManyToOne
	@JoinColumn(name="tipo",referencedColumnName="id_tipo_dispositivo")
	private TipoDispositivo tipo;
	@OneToMany(mappedBy="dispositivo")
	private Collection<Logs> logs;
	public Collection<Logs> getLogs() {
		return logs;
	}
	public void setLogs(Collection<Logs> logs) {
		this.logs = logs;
	}
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
	public Redes getId_red() {
		return id_red;
	}
	public void setId_red(Redes id_red) {
		this.id_red = id_red;
	}
	public TipoDispositivo getTipo() {
		return tipo;
	}
	public void setTipo(TipoDispositivo tipo) {
		this.tipo = tipo;
	}
	
}
