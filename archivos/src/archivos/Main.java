package archivos;

import java.io.File;
import java.util.Scanner;

public class Main {
	private static File home=new File(".");
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
				 case "3": break;
				 case "4": break;
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
}
