package main;

import java.sql.Connection;
import java.util.function.Predicate;

abstract public class SQLDAO {
	protected static Connection sConn=null;
	abstract boolean insert(Repo a);
	abstract Repo select(Repo a);
	abstract boolean update(Repo a);
	abstract boolean delete(Repo a);
	SQLDAO(Connection conn) {
		if (sConn==null) {
			sConn=conn;
		}
	}
}
