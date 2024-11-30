package aad.prueba;
import com.mysql.*;

import java.sql.*;

import javax.sql.*;
public class Main {
	public static void main(String[] args) {
		try (Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:32768/instituto", "user", "password")){
			Statement stmt=conn.createStatement();
			stmt.execute("select * from alumno");
			ResultSet rs=stmt.getResultSet();
			while (rs.next()) {
				System.out.print("codigo:"+rs.getInt(1)+" Nombre:"+rs.getString(3)+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
