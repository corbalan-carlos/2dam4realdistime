package pruebas;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws IOException {
		byte input[] = new byte[4];
		try (ServerSocket server=new ServerSocket(6666)) {
			Socket s=server.accept();
			System.setIn(s.getInputStream());
			
			while (System.in.read(input)!=-1) {
				for (byte b: input) System.out.format("0x%x ", b);
				System.out.println("\n##########");
			}
		}
	}

}
