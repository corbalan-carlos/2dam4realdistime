package main;

import java.sql.Connection;
import java.util.function.Predicate;

public class DAO {
	private Connection conn;
	public Connection getConn() {
		return conn;
	}
}
