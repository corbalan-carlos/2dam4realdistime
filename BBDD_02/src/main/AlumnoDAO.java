package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.MysqlType;

public class AlumnoDAO extends SQLDAO {
	static private final String INSERT= "insert into alumno values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	static private final String SELECT= "select * from alumno where nre=?";
	static private final String UPDATE= "update alumno set nombre=?,apellido1=?,apellido2=?,tipo_via=?,nombre_via=?,numero=?,"
			+ "escalera=?,piso=?,puerta=?,cp=?,pais=?,tlfn_fijo=?,tlfn_movil=?,email=?,fecha_nac=?,tutor=? where nre=?";
	static private final String DELETE= "delete from alumno where nre=?";

	AlumnoDAO(Connection conn) {
		super(conn);
	}
	@Override
	boolean insert(Repo r) throws IllegalArgumentException{
		if (! (r instanceof Alumno))  throw new IllegalArgumentException();
		Alumno a=(Alumno) r;
		try {
			PreparedStatement stmt=sConn.prepareStatement(INSERT);
			stmt.setString(1, a.nre);
			stmt.setString(2, a.dni);
			stmt.setString(3, a.nombre);
			stmt.setString(4, a.apellido1);
			stmt.setString(5, a.apellido2);
			stmt.setString(6, a.tipo_via);
			stmt.setString(7, a.nombre_via);
			stmt.setString(8, a.numero);
			stmt.setString(9, a.escalera);
			stmt.setString(10, a.piso);
			stmt.setString(11, a.puerta);
			stmt.setString(12, a.cp);
			stmt.setString(13, a.pais);
			stmt.setString(14, a.tlfn_fijo);
			stmt.setString(15, a.tlfn_movil);
			stmt.setString(16, a.email);
			stmt.setDate(17, a.fecha_nac);
			if (a.tutor==null) {
				stmt.setNull(18, MysqlType.FIELD_TYPE_VAR_STRING);
			} else {
				stmt.setString(18, a.tutor);
			}
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	Alumno select(Repo r) {
		if (! (r instanceof Alumno)) throw new IllegalArgumentException();
		Alumno a=(Alumno) r;
		try {
			PreparedStatement stmt = sConn.prepareStatement(SELECT);
			stmt.setString(1, a.nre);
			ResultSet rs = stmt.executeQuery();
			if (! rs.next()) {
				return null;
			}
			Alumno returnable = Alumno.AlumnoFactory();
			returnable.nre=a.nre;
			returnable.dni=rs.getString(2);
			returnable.nombre=rs.getString(3);
			returnable.apellido1=rs.getString(4);
			returnable.apellido2=rs.getString(5);
			returnable.tipo_via=rs.getString(6);
			returnable.nombre_via=rs.getString(7);
			returnable.numero=rs.getString(8);
			returnable.escalera=rs.getString(9);
			returnable.piso=rs.getString(10);
			returnable.puerta=rs.getString(11);
			returnable.cp=rs.getString(12);
			returnable.pais=rs.getString(13);
			returnable.tlfn_fijo=rs.getString(14);
			returnable.tlfn_movil=rs.getString(15);
			returnable.email=rs.getString(16);
			returnable.fecha_nac=rs.getDate(17);
			returnable.tutor=rs.getString(18);
			return returnable;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	boolean update(Repo r) {
		if (!(r instanceof Alumno)) return false;
		try {
		PreparedStatement stmt=sConn.prepareStatement(UPDATE);
		Alumno a=(Alumno) r;
			stmt.setString(1, a.nombre);
			stmt.setString(2, a.apellido1);
			stmt.setString(3, a.apellido2);
			stmt.setString(4, a.tipo_via);
			stmt.setString(5, a.nombre_via);
			stmt.setString(6, a.numero);
			stmt.setString(7, a.escalera);
			stmt.setString(8, a.piso);
			stmt.setString(9, a.puerta);
			stmt.setString(10, a.cp);
			stmt.setString(11, a.pais);
			stmt.setString(12, a.tlfn_fijo);
			stmt.setString(13, a.tlfn_movil);
			stmt.setString(14, a.email);
			stmt.setDate(15, a.fecha_nac);
			if (a.tutor==null) {
				stmt.setNull(16, MysqlType.FIELD_TYPE_VAR_STRING);
			} else {
				stmt.setString(16, a.tutor);
			}
			stmt.setString(17, a.nre);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	boolean delete(Repo r) {
		if (!(r instanceof Alumno)) return false;
		try {
			PreparedStatement stmt=sConn.prepareStatement(DELETE);
			Alumno a=(Alumno) r;
			stmt.setString(1, a.nre);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
