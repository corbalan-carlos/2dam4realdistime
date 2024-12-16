package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		URL url =new URL("http://localhost:8080");
		try (BufferedReader bf=new BufferedReader(new InputStreamReader(url.openStream()))) {
			bf.lines().forEach((String in) -> {
				System.out.println(in);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
