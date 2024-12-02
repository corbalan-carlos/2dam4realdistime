package psp021224Hilos;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class HobbitAyudante implements Runnable{
	private static CyclicBarrier cb=new CyclicBarrier(3);
	static volatile boolean notDone;
	@Override
	public void run() {
		try {
			Thread.sleep(5000+(System.nanoTime()%10000));
			System.out.print("Un hobbit acab de llegar a la fiesta\n");
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Un hobbit ha empezado a coger pasteles\n");
		while (notDone) {
			try {
				cogerPastel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print("Un hobbit ha dejado de trabajar\n");
	}
	static synchronized void cogerPastel() throws IOException {
		ByteBuffer bb=ByteBuffer.allocate(1);
		Main.mesa.source.read(bb);
	}
}
