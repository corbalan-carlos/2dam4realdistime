package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
/*
 * 
 * 
 */
class UDPClient {
	//La cosa seria que te lo diese el servidor en vez de estar hardcoded
	//O incluso que lo seleccionara el usuario
	//Pero weno
	private static final byte clientId=123;
	static private final int serverPort=666;
	public static void main(String args[]) {
		try {
			InetAddress serverIP=InetAddress.getByName("localhost");
			mainLoop(serverIP);
		} catch (UnknownHostException e) {
			System.err.print("Host no encontrado, apagando servidor....");
			System.exit(1);
		} catch (IOException e) {
			System.err.print("Error obteniendo el socket UDP, apagando servidor...");
			System.exit(2);
		}
	}
	private static void mainLoop(InetAddress serverIP) throws IOException {
			try (DatagramSocket originSocket=new DatagramSocket()) {
				while (true) {
					Thread.sleep(5000);
					UDPPacket pack=new UDPPacket(clientId,25.4);
					originSocket.send(new DatagramPacket(pack.toByteArr(),UDPPacket.LENGTH,serverIP, serverPort));
				}
			} catch (InterruptedException e) {
				System.err.print("Hilo interrumpido, apagando servidor...");
			}
	}
}
