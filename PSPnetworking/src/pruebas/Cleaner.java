package pruebas;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Cleaner implements Runnable {
	public ReentrantLock lock=new ReentrantLock();
	public Condition con= lock.newCondition();
	@Override
	public void run() {
		List<Connection> conns=Main.conns;
		while(true) {
			lock(conns);
			for (int i=0;i<conns.size();i++) {
				if (conns.get(i).getPrio()==-1) conns.remove(i);
			}
		}
	}
	private void lock(List<Connection> conns) {
			lock.lock();
			try {
				while (conns.isEmpty()) {
					con.await();
				}
			}catch (InterruptedException e) {
				return;
			}finally {
				lock.unlock();
			}
	}
	public Cleaner() {
	}
}
