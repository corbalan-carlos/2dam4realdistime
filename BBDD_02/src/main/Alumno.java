package main;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Scanner;
public class Alumno implements Repo{
	static private AlumnoDAO dao=null;
	@Nullable
	public String  nre=null;
	@Nullable
	public String dni=null;
	@Nullable
	public String nombre=null;
	@Nullable
	public String apellido1=null;
	@Nullable
	public String apellido2=null;
	@Nullable
	public String tipo_via=null;
	@Nullable
	public String nombre_via=null;
	@Nullable
	public String numero=null;
	@Nullable
	public String escalera=null;
	@Nullable
	public String piso=null;
	@Nullable
	public String puerta=null;
	@Nullable
	public String cp=null;
	@Nullable
	public String pais=null;
	@Nullable
	public String tlfn_fijo=null;
	@Nullable
	public String tlfn_movil=null;
	@Nullable
	public String email=null;
	@Nullable
	public Date fecha_nac=null;
	@Nullable(true)
	public String tutor=null;
	public Alumno(Connection conn) {
		dao=new AlumnoDAO(conn);
	}
	private Alumno() {};
	private Alumno(
			String nre, String dni,String nombre,String apellido1,String apellido2, String tipo_via, String nombre_via,
			String numero,String escalera, String piso,String puerta,String cp, String pais, String tlfn_fijo,
			String tlfn_movil,String email, Date fecha_nac, String tutor
			) {
			this.nre=nre;
			this.dni=dni;
			this.nombre=nombre;
			this.apellido1=apellido1;
			this.apellido2=apellido2;
			this.tipo_via=tipo_via;
			this.nombre_via=nombre_via;
			this.numero=numero;
			this.escalera=escalera;
			this.piso=piso;
			this.puerta=puerta;
			this.cp=cp;
			this.pais=pais;
			this.tlfn_fijo=tlfn_fijo;
			this.tlfn_movil=tlfn_movil;
			this.email=email;
			this.fecha_nac=fecha_nac;
			this.tutor=tutor;
	};
	public static Alumno AlumnoFactory () {
		if (dao==null) return null;
		return new Alumno();
	}
	public static Alumno AlumnoFactory (Scanner sc) {
		if (dao==null) return null;
		System.out.print("Escribe una e si deseas un alumno vacio:");
		if (sc.nextLine()=="e") return  new Alumno();
		System.out.print("Escribe el nre del alumno:");
		String nre=sc.nextLine();
		System.out.print("Escribe el dni del alumno:");
		String dni=sc.nextLine();
		System.out.print("Escribe el nombre del alumno:");
		String nombre=sc.nextLine();
		System.out.print("Escribe el primer apellido del alumno:");
		String apellido1=sc.nextLine();
		System.out.print("Escribe el segundo apellido del alumno:");
		String apellido2=sc.nextLine();
		System.out.print("Escribe el el tipo de via de la residencia del alumno:");
		String tipo_via=sc.nextLine();
		System.out.print("Escribe el nombre de la via de la residencia del alumno:");
		String nombre_via=sc.nextLine();
		System.out.print("Escribe el numero de la residencia del alumno:");
		String numero=sc.nextLine();
		System.out.print("Escribe la escalera de la residencia del alumno:");
		String escalera=sc.nextLine();
		System.out.print("Escribe el piso de la residencia del alumno:");
		String piso=sc.nextLine();
		System.out.print("Escribe la puerta de la residencia del alumno:");
		String puerta=sc.nextLine();
		System.out.print("Escribe el codigo postal de la residencia del alumno:");
		String cp=sc.nextLine();
		System.out.print("Escribe el pais de origen del alumno:");
		String pais=sc.nextLine();
		System.out.print("Escribe el numero de telefono fijo del alumno");
		String tlfn_fijo=sc.nextLine();
		System.out.print("Escribe el numero de telefono movil del alumno");
		String tlfn_movil=sc.nextLine();
		System.out.print("Escribe el email del alumno");
		String email=sc.nextLine();
		System.out.print("Escribe la fecha de nacimiento del alumno");
		Date fecha_nac=null;
		do {
			try {
				fecha_nac=Date.valueOf(sc.nextLine());
			} catch (IllegalArgumentException e) {
				System.out.print("Fecha introducida en un formato no correcto\n");
			}
		} while (fecha_nac==null);
		System.out.print("Escribe el tutor del alumno (deja en blanco para no introducir tutor)");
		String a=sc.nextLine();
		String tutor=(a==""?null:a);
		return new Alumno(nre,dni,nombre,apellido1,apellido2,tipo_via,nombre_via,numero,escalera,
				piso,puerta,cp,pais,tlfn_fijo,tlfn_movil,email,fecha_nac,tutor);
	}
	private void validateFields() throws FieldNotValidException, IllegalAccessException {
		for (Field f: this.getClass().getDeclaredFields()) {
			if (f.getAnnotationsByType(Nullable.class).length>0 && !f.getAnnotation(Nullable.class).value()) {
				if (f.get(this)==null) throw new FieldNotValidException("Campo "+f.getName()+" esta puesto a nulo");
			} 
		}
	}
	@Override
	public boolean create() {
		try {
			validateFields();
		} catch (FieldNotValidException e) {
			
			System.err.print(e.toString()+"Cancelando rutina\n");
			return false;
		} catch (IllegalAccessException e) {
			System.err.print("Error obteniendo los campos del objeto!!\n");
			System.exit(1);
		}
		return dao.insert(this);
	}
	@Override
	public boolean read() {
		if (this.nre==null) {
			return false;
		}
		Alumno rs=dao.select(this);
		if (rs==null) return false;
		this.nre=rs.nre;
		this.dni=rs.dni;
		this.nombre=rs.nombre;
		this.apellido1=rs.apellido1;
		this.apellido2=rs.apellido2;
		this.tipo_via=rs.tipo_via;
		this.nombre_via=rs.nombre_via;
		this.numero=rs.numero;
		this.escalera=rs.escalera;
		this.piso=rs.piso;
		this.puerta=rs.puerta;
		this.cp=rs.cp;
		this.pais=rs.pais;
		this.tlfn_fijo=rs.tlfn_fijo;
		this.tlfn_movil=rs.tlfn_movil;
		this.email=rs.email;
		this.fecha_nac=rs.fecha_nac;
		this.tutor=rs.tutor;
		return true;
	}
	@Override
	public boolean update() {
		try {
			validateFields();
		} catch (FieldNotValidException e) {
			
			System.err.print(e.toString()+"Cancelando rutina\n");
			return false;
		} catch (IllegalAccessException e) {
			System.err.print("Error obteniendo los campos del objeto!!\n");
			System.exit(1);
		}
		return dao.update(this);	
	}
	@Override
	public boolean delete() {
		 if (this.nre==null) return false;
		 return dao.delete(this);
	}
	
}
