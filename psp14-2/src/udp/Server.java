package udp;
import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.HashSet;
public class Server {

	public static void main(String[] args) {
		System.out.print(Character.BYTES);
		try (DatagramSocket ds=new DatagramSocket(6666)) {
			byte[] buffer=new byte[256];
			HashMap<String,InetAddress> ipa=new HashMap<>();
			while (true) {
				DatagramPacket message=new DatagramPacket(buffer, 256);
				ds.receive(message);
				Packet p=new Packet(message.getData());
				switch (p.p) {
				case ADD:
					ipa.put(p.s, InetAddress.getByAddress(p.ip));
					System.out.print("direccion ip añadida\n");
					break;
				case DISCARD:
					break;
				case REMOVE:
					System.out.print("direccion ip quitada\n");
					ipa.remove(p.s);
					break;
				case RESOLVE:
					System.out.print("dominio reseulto\n");
					message.setData(ipa.get(p.s).getAddress());
					ds.send(message);
					break;
				default:
					break;
				}
				ds.disconnect();
			}
		} catch (SocketException e) {
			System.err.print("Error obteniendo el socket, cerrando servidor...\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.print("Error obteniendo el datagrama, cerrando servidor...\n");
			e.printStackTrace();
		} 
	}

}
