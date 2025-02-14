package main;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * En un principio me gustaría haberlo hecho "bien" pero la verdad es que la escabilidad
 * y medio legibilidad es un lujo que ni me puedo permitir o que valga la pena en un 
 * proyecto de no mas de 5 horas
 * 
 * El objetivo principal era crear una interfaz DAO con la cual comunican las clase de tipo repo
 *  
 * Cualquier clase que haga de intermediario con el programa y datos externos seria DAO e implementaria 
 * una interfaz llamada DAO, la cual podria ser tanto por SQL como por ficheros asi que para las clases 
 * de tipo repo le pasas un DAO y esta se comunica con este DAO utilizando los metodos declarados en DAO
 * haciendolo agnostico al tipo de DAO que es. El DAO solo se tiene que encargar de cumplir la API declarada 
 * por la interfaz y la clase repo se lo debería tragar
 * 
 * Alguna cosa buena tiene que tener ponerle tanto overhead al proceso pero weno
 *  
 *  Reitero que era mi intencion pero no lo he llegado a hacer
 */
public class Main {
	public static void main(String[] args) throws IllegalAccessException, FieldNotValidException {
		try (Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/empleados_departamentos", "emp_dpt", "password")) {
			new Alumno(conn);
			Alumno a=Alumno.AlumnoFactory();
			a.nre="14323073";
			a.read();
			System.out.print(a.dni+" "+a.nombre+"\n");
			a.nre="0";
			a.dni="0";
			if (!a.create()) System.out.print("vaya...");
			a.read();
			System.out.print(a.nre+" "+a.nombre+"\n");
			a.nombre="hola";
			a.update();
			a.read();
			System.out.print(a.nre+" "+a.nombre+"\n");
			a.delete();
			if (a.read()) System.err.print("mierda");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.print("uh oh");
		}
	}

}
