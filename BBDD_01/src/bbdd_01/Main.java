package bbdd_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	static public void main(String[] args) {
		
		try (Connection conn=DriverManager.getConnection("localhost", "emp_dpt", "pass")){ 
			System.out.println("Conexion hechar correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}
