package psp021224Hilos;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.Random;

public class Frodo implements Runnable {
	
	@Override
	public void run() {
		Main.g.pipa.lock();
		System.out.print("pipa adquirida\n");
		for (int i=0;i<100;) {
			for (int j=0;j<14;j+=2,i+=2) {
				try {
					hornearPastel();
					System.out.print("2 pasteles han sido horneados\n");
					depositarPasteles((byte) i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Main.g.despertar();
			System.out.println("Gandalf ha sido despertado y renovado el hechizo en el horno");
			Main.g.pipa.lock();
		}
		HobbitAyudante.notDone=false;
		Main.g.notDone=false;
		System.out.print("Frodo ha terminado con los pasteles\n");
	}
	private void hornearPastel() throws InterruptedException {
		long time=System.nanoTime()%500+500;
		Thread.sleep(time);
	}
	private void depositarPasteles(byte b) throws IOException {
		ByteBuffer bb=ByteBuffer.allocate(2);
		bb.put(b);
		bb.put((byte) (b+1));
		Main.mesa.sink.write(bb);
	}
}
