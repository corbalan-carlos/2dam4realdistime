package a;

public class Main {
	public static void main (String[] args) throws InterruptedException {
		for (int i=0;i<Barbero.N_BARBEROS;i++) {
			new Thread(new Barbero()).start();
		}
		Thread.sleep(1000);
		while (true) {
			new Thread(new Cliente()).start();
			Thread.sleep(1000);
		}
	}
}
