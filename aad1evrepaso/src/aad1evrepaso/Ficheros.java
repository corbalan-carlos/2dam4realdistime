package aad1evrepaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author educarm
 */
public class Ficheros {
	final private static File ventasFile= new File("ventas.txt");
	final private static File alumnosBinFile= new File("cca.bin");
	static private BufferedReader ventasBReader;
	static private RandomAccessFile alumnosRAF;
	static {
		try {
		 ventasBReader=new BufferedReader(new FileReader(ventasFile));
		} catch (Exception e) {
			System.exit(-1);
		}
	}
	static {
		try {
			alumnosRAF=new RandomAccessFile(alumnosBinFile, "rw");
		} catch (Exception e) {
			System.exit(-1);
		}
	}
    public void apartadoA() {
    		ventasBReader.lines().forEach( (String s) -> {
    		});
    }

    public void apartadoB() {
    	alumnoRAF
    }

    public void apartadoC() {

    }

    public void apartadoD() {

    }
    
}
