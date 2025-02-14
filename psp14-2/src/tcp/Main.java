package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {
	/*
	 * No me ha dado tiempo a terminarlo pare a lo mejor si me da a explicarlo
	 * Se tiene una listaenlazada de los comandos que llegan de cada uno de los clientes
	 * Un hilo por habitacion
	 * Un hashset de usarios (tendria que haber sido una clase por ella misma)
	 * Y una lista de sockets
	 * 
	 *  El hilo principal aniade sockets a la lista conforme llegan las conexiones
	 *  Listener itera por cada una de las conexiones de una manera no bloqueante
	 *  Listener añade los paquetes a un FIFO usado por RequestHandler
	 *  RequestHandler se encarga de administrar las requests generales
	 *  Las requests de habitacion a habitacion se encargan los propios hilos
	 *  Como escupir de vuelta?
	 *  Ni me lo he planteado
	 *  ¯\_(ツ)_/¯
	 */
	public static LinkedList<Command> deck=new LinkedList<>();
	public static HashMap<String, Thread> rooms=new HashMap<>();
	public static HashSet<String> users=new HashSet<>();
	public static List<Socket> connections=new ArrayList<Socket>();
	public static void main(String[] args) {
		new Thread(new RequestHandler()).start();
		new Thread(new Listener()).start();
		try (ServerSocket sck=new ServerSocket(6666)) {

			while (true) {
				Socket s;
				s=sck.accept();
				connections.add(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
