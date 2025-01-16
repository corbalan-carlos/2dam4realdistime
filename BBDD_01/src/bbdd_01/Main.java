package bbdd_01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.cj.jdbc.ConnectionGroup;

public class Main {

	static public void main(String[] args) throws ClassNotFoundException {
		
		try (Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/empleados_departamentos",
				"emp_dpt", "password"); Scanner sc=new Scanner(System.in)){
			System.out.println("Conexion hecha correctamente");
			String a;
			do {
				a=sc.nextLine();
				switch (a) {
				case ("1"): insertIntoEmpleado(conn, sc);
							break;
				case ("2"): deleteFromEmpleado(conn, sc);
							break;
				}
			} while(!a.matches("0"));
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	private static void deleteFromEmpleado(Connection conn,Scanner sc) {
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from empleados where (nDIEmp=?)");
			System.out.print("Escriba el nDIe del empleado en cuestión:");
			String s=sc.nextLine();
			stmt.setString(1, s);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print("Algo ha salido mal, aqui está el mensaje mas explicado");
			System.out.print(e.getMessage());	
		}

		
	}
	private static void insertIntoEmpleado(Connection conn,Scanner sc) {
		try {
		PreparedStatement stmt = conn.prepareStatement("insert into empleados values"+
					"(?,?,?,?,?,?,?,?,?,?)");
		String DNI, nombre,sexS,fechanacS,fecincS,salS,comisionS,cargo,jefe,depto;
		Date fechanac, fecinc;
		float sal, comision;
		System.out.print("Insertar en la tabla \"empleados\"\n");
		System.out.print("DNI:");
		DNI=sc.nextLine();
		System.out.print("Nombre:");
		nombre=sc.nextLine();
		System.out.print("Sexo: ");
		sexS=sc.nextLine();
		System.out.print("Fecha Nac (YYYY-MM-DD):");
		fechanacS=sc.nextLine();
		System.out.print("Fecha Inco (YYYY-MM-DD):");
		fecincS=sc.nextLine();
		System.out.print("Salario:");
		salS=sc.nextLine();
		System.out.print("Comision: ");
		comisionS=sc.nextLine();
		System.out.print("Cargo: ");
		cargo=sc.nextLine();
		System.out.print("Depto: ");
		depto=sc.nextLine();
		fechanac=Date.valueOf(fechanacS);
		fecinc=Date.valueOf(fecincS);
		sal=Float.parseFloat(salS);
		comision=Float.parseFloat(comisionS);
		int i=1;
		stmt.setString(i++, DNI);
		stmt.setString(i++, nombre);
		stmt.setString(i++, sexS);
		stmt.setDate(i++, fechanac);
		stmt.setDate(i++, fecinc);
		stmt.setFloat(i++, sal);
		stmt.setFloat(i++, comision);
		stmt.setString(i++, cargo);
		stmt.setNull(i++, Types.VARCHAR);
		stmt.setString(i++, depto);
		stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.print("Algo ha salido mal, aqui está el mensaje mas explicado");
			System.out.print(e.getMessage());
		} 
	}
}
