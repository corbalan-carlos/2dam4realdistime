package bbdd_01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Main {

	static public void main(String[] args) throws ClassNotFoundException {
		//"pass" para clase "password" para casa
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
				case ("3"): updateEmpleado(conn,sc);
							break;
				case ("4"): mostrarEmpleados(conn,sc);
							break;
				case ("5"): insertIntoDepartamentos(conn,sc);
							break;
				case ("6"): deleteFromDepartamentos(conn,sc);
							break;
				case ("7"): updateFromDepartamentos(conn,sc);
							break;
				case ("8"): mostrarDepartamentos(conn,sc);
				}
			} while(!a.matches("0"));
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	private static void mostrarDepartamentos(Connection conn, Scanner sc) {
		try {
			ResultSet r=conn.createStatement().executeQuery("select * from departamentos");
			while (r.next()) {
					System.out.format("Codigo Departamento:%s Nombre Departamento:%s Ciudad:%s Codigo Director:%s\n",
					r.getString(1), r.getString(2), r.getString(3), r.getString(4)
					);
			}
		} catch (SQLException e) {
			System.out.print("Algo ha salido mal, aqui está el mensaje mas explicado\n");
			System.out.print(e.getMessage());
		}	
	}
	private static void updateFromDepartamentos(Connection conn, Scanner sc) {
		String[] parameters=new String[4];
		
		try {
			System.out.print("Escribe el codDepto del departamento en cuestión:");
			String s=sc.nextLine();
			ResultSet r=conn.createStatement().executeQuery("select count(*) from departamentos where codDepto=\""+s+"\"");
			r.next();
			if (
					r.getInt(1)==0
				) {
				System.out.print("Departamento no encontrado\n");
				return;
			}
			r=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE).executeQuery("select * from departamentos where nDIEmp=\""+s+"\"");
			r.next();
			
			System.out.format("Codigo Departamento:%s Nombre Departamento:%s Ciudad:%s Codigo Director:%s\n",
					r.getString(1), r.getString(2), r.getString(3), r.getString(4)
					);
			System.out.print("Escribe el nuevo valor para los campos (Dejar vacio para ignorarlo)\n");
			System.out.print("Codigo Departamento:");
			parameters[0]=sc.nextLine();
			System.out.print("Nombre Departamento: ");
			parameters[1]=sc.nextLine();
			System.out.print("Ciudad:");
			parameters[2]=sc.nextLine();
			System.out.print("Codigo Director");
			if (parameters[0]!="") {
				r.updateString(2, parameters[0]);
			}
			if (parameters[1]!="") {
				r.updateString(3, parameters[1]);
			}
			if (parameters[2]!="") {
				r.updateString(4, parameters[2]);
			}
			if (parameters[3]!="") {
				r.updateString(5, parameters[3]);
			}
			r.updateRow();
		} catch (SQLException e) {
			System.out.print("Algo ha salido mal, aqui está el mensaje mas explicado\n");
			System.out.print(e.getMessage());		
		}	
	}
	/*
	 * No estoy seguro a la portabilidad de este codigo, 
	 * supuestamente deberia funcionar con MySQL v 9.10 community
	 * utiliza el codigo devuelto por la SQLException para saber 
	 * si se ha intentado borrar una fila padre y actuar correspondientemente
	 */
	private static void deleteFromDepartamentos(Connection conn, Scanner sc) {
		try {
			System.out.print("Introduzca el nombre del departamento a borrar:");
			String s =sc.nextLine();
			ResultSet r=conn.createStatement().executeQuery("select nombreDpto, ciudad from departamentos where nombreDpto=\""+s+"\"");
			if (!r.next()) {
				System.out.print("Departamento no encontrado\n");
				return;
			}
			do {
				System.out.print("Departamento:"+s+" Localizado en: "+r.getString(2)+"\n");
			} while (r.next());
			System.out.print("Introduzca la ciudada del departamento:");
			String s1=sc.nextLine();
			conn.createStatement().executeUpdate("delete from departamentos where nombreDpto=\""+s+"\" and ciudad=\""+s1+"\"");
		
		} catch (SQLException e) {
			if (e.getErrorCode()==23000) {
				System.out.print("El departamento siendo borrado tiene filas descendendientes, no se puede realizar la operación\n");
			} else {
				System.out.print("Algo ha salido mal, aqui está el mensaje mas explicado\n");
				System.out.print(e.getMessage());
			}
		}
	}
	private static void insertIntoDepartamentos(Connection conn, Scanner sc) {
		try {
			PreparedStatement stmt=conn.prepareStatement("insert into empleados values (?,?,?,?)");
			String codDepto,nombreDepto,ciudad,codDirector;
			System.out.print("Insertar en la tabla \"empleados\"\n");
			System.out.print("Codigo del departamento: ");
			codDepto=sc.nextLine();
			System.out.print("Nombre del departamento: ");
			nombreDepto=sc.nextLine();
			System.out.print("Ciudad: ");
			ciudad=sc.nextLine();
			System.out.print("Codigo del director: ");
			codDirector=sc.nextLine();
			stmt.setString(1, codDepto);
			stmt.setString(2, nombreDepto);
			stmt.setString(3, ciudad);
			stmt.setString(4, codDirector);
			stmt.execute();
		} catch (SQLException e) {
			System.out.print("Algo ha salido mal, aqui está el mensaje mas explicado\n");
			System.out.print(e.getMessage());		
		}
	}
	/*lo odio*/
	private static void updateEmpleado(Connection conn, Scanner sc) {
		String[] parameters=new String[9];
		
		try {
			System.out.print("Escribe el DNI del empleado en cuestión:");
			String s=sc.nextLine();
			ResultSet r=conn.createStatement().executeQuery("select count(*) from empleados where nDIEmp=\""+s+"\"");
			r.next();
			if (
					r.getInt(1)==0
				) {
				System.out.print("Empleado no encontrado\n");
				return;
			}
			r=conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE).executeQuery("select * from empleados where nDIEmp=\""+s+"\"");
			r.next();
			
			System.out.format("DNI:%s Nombre: %s Sexo: %s\nFechaNac: %s FechaInc: %s Salario:%f Comison:%s\nCargo: %s Jefe: %s Dpto:%s\n",
					r.getString(1), r.getString(2), r.getString(3), r.getDate(4).toString(), r.getDate(5).toString(), r.getFloat(6), r.getFloat(7),
					r.getString(8),r.getString(9),r.getString(10)
					);
			System.out.print("Escribe el nuevo valor para los campos (Dejar vacio para ignorarlo)\n");
			System.out.print("Nombre:");
			parameters[0]=sc.nextLine();
			System.out.print("Sexo: ");
			parameters[1]=sc.nextLine();
			System.out.print("Fecha Nac (YYYY-MM-DD):");
			parameters[2]=sc.nextLine();
			System.out.print("Fecha Inco (YYYY-MM-DD):");
			parameters[3]=sc.nextLine();
			System.out.print("Salario:");
			parameters[4]=sc.nextLine();
			System.out.print("Comision: ");
			parameters[5]=sc.nextLine();
			System.out.print("Cargo: ");
			parameters[6]=sc.nextLine();
			System.out.print("Jefe: ");
			parameters[7]=sc.nextLine();
			System.out.print("Depto: ");
			parameters[8]=sc.nextLine();
			if (parameters[0]!="") {
				r.updateString(2, parameters[0]);
			}
			if (parameters[1]!="") {
				r.updateString(3, parameters[1]);
			}
			if (parameters[2]!="") {
				r.updateString(4, parameters[2]);
			}
			if (parameters[3]!="") {
				r.updateDate(5, Date.valueOf(parameters[3]));
			}
			if (parameters[4]!="") {
				r.updateDate(6, Date.valueOf(parameters[4]));
			}
			if (parameters[5]!="") {
				r.updateFloat(7, Float.parseFloat(parameters[5]));
			}
			if (parameters[6]!="") {
				r.updateFloat(8, Float.parseFloat(parameters[6]));
			}
			if (parameters[7]!="") {
				r.updateFloat(9, Float.parseFloat(parameters[7]));
			}
			if (parameters[8]!="") {
				r.updateFloat(10, Float.parseFloat(parameters[8]));
				
			}
			r.updateRow();
		} catch (SQLException e) {
			System.out.print("Algo ha salido mal, aqui está el mensaje mas explicado\n");
			System.out.print(e.getMessage());		
		}
	}
	private static void mostrarEmpleados(Connection conn, Scanner sc) {
		try {
			ResultSet r=conn.createStatement().executeQuery("select * from empleados");
			while (r.next()) {
				System.out.format("DNI:%s Nombre: %s Sexo: %s\nFechaNac: %s FechaInc: %s Salario:%f Comison:%s\nCargo: %s Jefe: %s Dpto:%s\n",
						r.getString(1), r.getString(2), r.getString(3), r.getDate(4).toString(), r.getDate(5).toString(), r.getFloat(6), r.getFloat(7),
						r.getString(8),r.getString(9),r.getString(10)
						);	
			}
		} catch (SQLException e) {
			System.out.print("Algo ha salido mal, aqui está el mensaje mas explicado\n");
			System.out.print(e.getMessage());
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
			System.out.print("Algo ha salido mal, aqui está el mensaje mas explicado\n");
			System.out.print(e.getMessage());
		} 
	}
}
