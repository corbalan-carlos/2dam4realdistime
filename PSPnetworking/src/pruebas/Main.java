package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.channels.ServerSocketChannel;

public class Main {

	public static void main(String[] args) throws IOException {
		ServerSocketChannel ssc=ServerSocketChannel.open();
		ssc.bind(new InetSocketAddress(80), 1);
		InputStream is;
		int r;
		do {
			ssc.accept();
			System.out.print("Conexion recibida");
		} while (true);
	}

}
