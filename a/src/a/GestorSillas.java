package a;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GestorSillas { 
	public static final int N_SILLAS=5; 
	private static Semaphore semaphore=new Semaphore(N_SILLAS);
	public static Silla[] sillas= { new Silla(), new Silla(), new Silla(), new Silla(), new Silla()};
	private static Lock lock=new ReentrantLock();
	public static synchronized int sentarse(Cliente clienteASentar) {
		while (!lock.tryLock());
		if (semaphore.tryAcquire()) {
			for (int i=0;i<N_SILLAS;i++) {
				if (!sillas[i].taken) {
					sillas[i].priority=1;
					sillas[i].clienteSentado=clienteASentar;
					sillas[i].taken=true;
					lock.unlock();
					return i;
				}
			}
		}
		lock.unlock();
		return -1;
	}
	public static synchronized void irse(Cliente cliente) {
		while (!lock.tryLock());
		for (Silla s:sillas ) {
			s.priority++;
		}
		sillas[cliente.silla].priority=0;
		sillas[cliente.silla].taken=false;
		semaphore.release();
		lock.unlock();
	}
	public static synchronized int getSilla () {
		while (!lock.tryLock());
		int max=0;
		int silla=-1;	
		for (int i=0;i<GestorSillas.N_SILLAS;i++) {
			if (GestorSillas.sillas[i].priority>max) {
				max=GestorSillas.sillas[i].priority;
				silla=i;
			}
			
		}
		lock.unlock();
		return silla;
		
	}
	public static class Silla {
		int priority;
		Cliente clienteSentado;
		boolean taken;
		public Silla () {
			priority=0;
			clienteSentado=null;
		}
	}
}
