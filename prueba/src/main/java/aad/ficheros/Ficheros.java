/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aad.ficheros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author educarm
 */
public class Ficheros {
	private final String file="empleados1.bin";
    public List<Empleado> getEmpleados() throws IOException {
        List<Empleado> listaRetornable=new ArrayList<>();
        try (RandomAccessFile raf=new RandomAccessFile(file,"r")) {
        	long longitud=raf.length();
        	while (raf.getFilePointer()<longitud) {
        		Empleado topStack=new Empleado();
        		topStack.id=raf.readInt();
        		topStack.nombre=raf.readUTF();
        		topStack.oficio=raf.readUTF();
        		topStack.fecha_alt=raf.readUTF();
        		topStack.salario=raf.readFloat();
        		topStack.comision=raf.readFloat();
        		topStack.departamento=raf.readInt();
        		listaRetornable.add(topStack);
        	}
        	return listaRetornable;
        } catch (IOException e) {
        	e.printStackTrace();
        }
        throw new IOException();
    }

    public void agregarEmpleado() {
        
    }
}
