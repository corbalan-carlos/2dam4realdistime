package pruebas;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.locks.Condition;

import javax.net.ssl.SSLContext;

public class Connection {
	private int prio;
	private InputStream is;
	private OutputStream os;
	private Socket s;
	Connection(Socket s) throws IOException {
		this.s=s;
		is=s.getInputStream();
		os=s.getOutputStream();
		this.prio=1;
	}
	void writeInto(byte[] input) throws SocketClosedException,IOException {
		if (s.isClosed()) throw new SocketClosedException();
		os.write(input);
	}
	byte[] read(int bufferSize) throws SocketClosedException,IOException {
		if (s.isClosed()) throw new SocketClosedException();
		byte[] returnable=new byte[bufferSize];
		is.read(returnable);
		return returnable;
	}
	void close() throws SocketClosedException, IOException {
		if (s.isClosed()) throw new SocketClosedException();
		prio=-1;
		s.close();
	}
	int getPrio() {
		return this.prio;
	}
	void forget() {
		
		prio=-1;
	}
}
