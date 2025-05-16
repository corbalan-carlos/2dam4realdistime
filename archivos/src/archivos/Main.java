package archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static File home=new File(".");
	private final static String NAME="carlos corbalan andreu";
	public static void main(String[] args) {

		File dir=new File(".");
		try (Scanner sc = new Scanner(System.in)) {
			String line=sc.nextLine();
			while(line!="7") {
				switch (line) {
				 case "1": ls(dir);
					 break;
				 case "2": dir=cd(dir,sc);
					 break;
				 case "3": 
						 touch(dir,sc);
						 break;
				 case "4": 
					 cat(dir,sc);
					 break;
				 			
				 case "5": break;
				 case "6": break;
				 }
				 line=sc.nextLine();
			 }
		}
	}
	private static void ls(File dir) {
		if (!dir.isDirectory()) {
			System.err.print("No es un directorio\n");
			return;
		}
		for (File s:dir.listFiles()) {
			if (s.isDirectory()) System.out.print(s+"\n");
		}
	}
	private static File cd(File dir, Scanner sc) {
		if (!dir.isDirectory()) {
			System.err.print("No es un directorio\n");
			return dir;
		}
		String result=sc.nextLine();
		
		if (result=="") {
			return home;
		}
		for (File f: dir.listFiles()) {
			if (f.isDirectory()&&f.toString().matches(result)) return f;
		}
		System.out.print("Directorio no encontrado o el nombre proporcionado no es un directorio\n");
		return dir;
	}
	private static void touch(File dir, Scanner sc) {
		if (!dir.canWrite()) {
			System.err.print("No se puede escribir sobre el directorio\n");
			return;
		}
		String name=sc.nextLine();
		File toCreate=new File(dir,name);
		try {
			if (toCreate.createNewFile()) {
				try (FileOutputStream fos =new FileOutputStream(toCreate)) {
					fos.write(NAME.getBytes());
				} catch (IOException e) {
					System.err.print("Error escribiendo al fichero:"+e.getMessage()+"\n");
				}
			} else {
				System.err.print("Fichero ya existente\n");
			}
		} catch (IOException e) {
			System.err.print("Error creando fichero:"+e.getMessage()+"\n");
		}
	}
	private static void cat(File dir,Scanner sc) {
		String name=sc.nextLine();
		File toRead=new File(dir,name);	
		if (!toRead.canRead()) {
			System.err.print("No se tienen permisos suficientes\n");
			return;
		}
		try (FileReader fr=new FileReader(toRead)) {
			char buffer[]=new char[256];
			int left;
			while ((left=fr.read(buffer,0,256))!=-1) {
				System.out.print(new String(buffer,0,left));
			}
		} catch (IOException e) {
			System.err.print("Error procesando el archivo"+e.getMessage()+"\n");
		}
	}
	private static void append(File dir, Scanner sc) {
		String name=sc.nextLine();
		File toWrite=new File(dir,name);	
		if (!toWrite.exists()) {
			System.err.print("Fichero no existenete\n");
			return;
		}
		if (!toWrite.canWrite()) {
			System.err.print("No se tienen permisos suficientes\n");
			return;
		}
		String text=sc.nextLine();
		try (FileOutputStream fos =new FileOutputStream(toWrite,true)) {
			fos.write(text.getBytes());
		} catch (IOException e) {
			System.err.print("Error escribiendo al fichero:"+e.getMessage()+"\n");
		}
	}
	private static void rm(File dir,Scanner sc) {
		String name=sc.nextLine();
		File toDelete=new File(dir,name);
		if (!toDelete.exists()) {
			System.err.print("Fichero no existente\n");
			return;
		}
		if (toDelete.delete()) {
			System.out.print("Fichero borrado correctamente\n");
			return;
		}
		System.out.print("El fichero no se ha podido borrar correctamente");
		return;
	}
}
