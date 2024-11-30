/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aad.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import aad.ficheros.Empleado;

/**
 *
 * @author educarm
 */
public class EmpresaBD {
	private Connection conn;
	private PreparedStatement insertarQ;
	private DateFormat dateMaker;
    public void insertaEmpleados(List<Empleado> empleados) throws SQLException {
    	for (Empleado e:empleados ) {
    		insertarQ.clearParameters();
    		insertarQ.setInt(1, e.id);
    		insertarQ.setString(2, e.nombre);
    		insertarQ.setString(3, e.oficio);
    		insertarQ.setDate(4, java.sql.Date.valueOf(e.fecha_alt));
    		insertarQ.setFloat(5, e.salario);
    		insertarQ.setFloat(6, e.comision);
    		insertarQ.setInt(7, e.departamento);
    		insertarQ.addBatch();
    	}
    	insertarQ.executeBatch();
    	insertarQ.clearBatch();
    }

    public void modificaTablaDepartamento() throws SQLException {
    	//perezoso pero funciona
    	Statement stmt=conn.createStatement();
    	stmt.addBatch("alter table departamentos add (jefe int, foreign key (jefe)"
    			+ " references empleados(id) );");
    	stmt.addBatch("update departamentos set jefe=7782 where id=10;");
    	stmt.addBatch("update departamentos set jefe=7566 where id=20;");
    	stmt.addBatch("update departamentos set jefe=7698 where id=30;");
    	stmt.addBatch("update departamentos set jefe=7934 where id=40;");
    	stmt.executeBatch();
    }

    public boolean intercambiaDepartamento(int idEmpleado1, int idEmpleado2) throws SQLException {
        Statement stmt=conn.createStatement();
        if (!stmt.execute("select * from empleados e inner join departamentos d on e.id=d.jefe where e.id=" + idEmpleado1+";")) {
        	return false;
        }
        stmt.execute("update empleados e set departamento=(select e.departamento where e.id="+idEmpleado2+") "
        		+"where ("+idEmpleado2+") in (select e.id where id not in (select jefe from departamentos dpt where dpt.jefe=e.id))"+
        		"and e.id="+idEmpleado1);
        if (stmt.getUpdateCount()==0) return false;
        stmt.execute("update empleados e set departamento=(select e.departamento where e.id="+idEmpleado1+")" +
        		"where e.id="+idEmpleado2);
        if (stmt.getUpdateCount()==0) return false;
        return true;
    }

    public void imprimeMediaSalarioLocalidad() {
        
    }
    public EmpresaBD() throws SQLException {
    	conn=DriverManager.getConnection("jdbc:mysql://localhost:32768/instituto","user","password");
    	insertarQ=conn.prepareStatement("INSERT INTO empleados VALUES(?,?,?,?,?,?,?);");
    	dateMaker=new SimpleDateFormat();
    }
}
