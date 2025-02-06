package main;
import java.lang.reflect.Field;
import java.sql.*;
public class Alumno implements Repo{
	private final String CREATE_STMT="insert into alumno values" +
			"(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	@Nullable
	private String  nre;
	@Nullable
	private String dni;
	@Nullable
	private String nombre;
	@Nullable
	private String apellido1;
	@Nullable
	private String apellido2;
	@Nullable
	private String tipo_via;
	@Nullable
	private String nombre_via;
	@Nullable
	private String numero;
	@Nullable
	private String escalera;
	@Nullable
	private String piso;
	@Nullable
	private String puerta;
	@Nullable
	private String cp;
	@Nullable
	private String pais;
	@Nullable
	private String tlfn_fijo;
	@Nullable
	private String email;
	@Nullable
	private Date fecha_nac;
	@Nullable(true)
	private String tutor;
	
	public static Alumno AlumnoFactory () {
		//TODO
	}
	private void validateFields() throws FieldNotValidException, IllegalAccessException {
		for (Field f: this.getClass().getDeclaredFields()) {
			if (!f.getAnnotation(Nullable.class).value()) {
				if (f.get(this)==null) throw new FieldNotValidException("Campo "+f.getName()+" esta puesto a nulo");
			} 
		}
	}
	@Override
	public boolean create(DAO dao) throws SQLException {
		PreparedStatement stmt=dao.getConn().prepareStatement(CREATE_STMT);

	}
	@Override
	public boolean read() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
