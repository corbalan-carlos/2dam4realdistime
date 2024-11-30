package a;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cliente implements Runnable {
	public int silla;
	private Lock lock=new ReentrantLock();
	public Condition condicion=lock.newCondition();
	volatile boolean done;
	@Override
	public void run() {
		if ((silla=GestorSillas.sentarse(this))==-1) {
			//System.out.println("La barberia estaba llena asi que un cliente se ha ido");
			return;
		}
		System.out.println("Un cliente se ha sentado en la silla "+silla);
		while (!done);
		GestorSillas.irse(this);
	//	System.out.print("Un cliente ha sido atendido y se ha ido\n");
	}
	public synchronized boolean lock() {
		return lock.tryLock();
	}
	public synchronized void unlock() {
		lock.unlock();
	}
	public synchronized void wakeTFUp() {
		done=true;
	}
}
