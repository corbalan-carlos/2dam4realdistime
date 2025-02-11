package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
	static List<Connection> conns;
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket ss=new ServerSocket(6666);
		conns=new Vector<>();
		Replier replier=new Replier();
		Cleaner cleaner=new Cleaner();
		new Thread(replier);
		new Thread(cleaner);
		while (true) {
			try {
				conns.add(new Connection(ss.accept()));
				if (replier.eepy) {
					replier.lock.lock();
					replier.con.signal();
				}
			} catch (IOException e) {
				conns.removeLast();
			}
			
		}
	}	
}
