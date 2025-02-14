package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Listener implements Runnable{
	@Override
	public void run() {
		while (true) {
			for (Socket s : Main.connections) {
				InputStream is=null;
				try {
					is=s.getInputStream();
					System.out.print(is.readNBytes(10));
				} catch (IOException e) {
					System.exit(1);
					e.printStackTrace();
				}
			}
		}
	}

}
