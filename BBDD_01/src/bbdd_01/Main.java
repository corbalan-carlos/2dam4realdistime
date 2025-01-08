package bbdd_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.ConnectionGroup;

public class Main {

	static public void main(String[] args) throws ClassNotFoundException {
		
		try (Connection conn=DriverManager.getConnection("jdbc:mysql://localhost", "user", "pass")){
			System.out.println("Conexion hecha correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}
