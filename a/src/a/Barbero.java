package a;

public class Barbero implements Runnable {
	public static final int N_BARBEROS=5; 
	@Override
	public void run() {
		while (true ) {
			int silla=GestorSillas.getSilla();
			if (silla==-1) {
				try {
					System.out.println("No habia clientes asi que un  barbero se ha dormido");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			while (true) {
				if (silla==GestorSillas.N_SILLAS) silla=0;
				if (GestorSillas.sillas[silla].clienteSentado==null) {
					silla++;
					continue;
				}
				if (GestorSillas.sillas[silla].clienteSentado.lock()) break;
				silla++;
			}
			try {
				Thread.sleep(3000);
				GestorSillas.sillas[silla].clienteSentado.wakeTFUp();
				System.out.print("El cliente en la silla "+silla+" ha sido atendido\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
