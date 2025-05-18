package main;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Entity;
public class InfoUsuarios {
	public String correo;
	public Long numLogs;
	public Date fechaMinima;
	public Date fechaMaxima;
	public InfoUsuarios(String correo,Long numLogs,Date fechaMinima,Date fechaMaxima) {
		this.correo=correo;
		this.numLogs=numLogs;
		this.fechaMinima=fechaMinima;
		this.fechaMaxima=fechaMaxima;
	}
}
