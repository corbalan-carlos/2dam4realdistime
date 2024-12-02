package psp021224Proceso;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner input=new Scanner(System.in);
		List<String> lista;
		ProcessBuilder pBuilder=new ProcessBuilder();
		String buffer;
		String redireccion;
		File fRedireccion;
		System.out.println("Elija un comando a realizar");
		buffer=input.nextLine();
		lista=Arrays.asList(buffer.split(" "));
		pBuilder.command(lista);
		System.out.println("Elije un fichero al que redirigir el stdout and stderr (vacio para 1,2)");
		redireccion= input.nextLine();
		if (redireccion.isBlank()) {
			pBuilder.redirectError(Redirect.INHERIT);
			pBuilder.redirectOutput(Redirect.INHERIT);
		} else {
			fRedireccion=new File(redireccion);
			pBuilder.redirectError(fRedireccion);
			pBuilder.redirectOutput(fRedireccion);
		}
		pBuilder.start().waitFor();
		
	}

}
