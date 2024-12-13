package prueba;

public class A implements Runnable {
	public int i=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (;;i++);
	}
	public synchronized void hola() throws InterruptedException {
		this.wait();
	}
}
