package pruebas;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Replier implements Runnable {
	public boolean eepy=false;
	public ReentrantLock lock=new ReentrantLock();
	public Condition con=lock.newCondition();
	@Override
	public void run() {
		List<Connection> conns=Main.conns;
		while (true) {
			if (conns.isEmpty()) {
				lock.lock();
				eepy=true;
				try {
					while (conns.isEmpty()) {
						con.await();
					}
				} catch (InterruptedException e) {
					return;
				}finally {
					lock.unlock();
				}
			}
			
			Connection conn=conns.getFirst();
			byte[] buff=null;
			try {
				buff=conn.read(256);
			} catch (SocketClosedException e) {
				System.err.print("Socket cerrado, eliminando conexion...");
				conn.forget();
				continue;
			} catch (IOException e) {
				System.err.print("Error de IO");
			} finally {
				conns.remove(0);
				conns.add(conn);
			}
			if (buff==null) {
				System.err.print("Error leyendo buffer, saliendo"); 
				continue;
			}
			System.out.print(buff[0]);
			if (buff[0]==0x41) {
				try {
					conn.close();
				} catch (SocketClosedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
