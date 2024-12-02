package psp021224Hilos;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Gandalf implements Runnable{
	public final Lock pipa=new ReentrantLock();
	public final Condition wakeUpG =pipa.newCondition();
	public volatile boolean notDone=true;
	@Override
	public void run() {
		while (notDone)  {
			pipa.lock();
			try {
				wakeUpG.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void despertar() {
		wakeUpG.signal();
		pipa.unlock();
	}
}
