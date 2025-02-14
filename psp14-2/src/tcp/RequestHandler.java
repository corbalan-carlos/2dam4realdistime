package tcp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.*;

public class RequestHandler implements Runnable {
	public Lock lock =new ReentrantLock();
	@Override
	public void run() {
		LinkedList<Command> deck= Main.deck;
		//No es bonito pero no tengo tiempo 
		while (true) {
			if (deck.isEmpty())
				try {
					Thread.sleep(500);
					continue;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			lock.lock();
			Command currentCmd=deck.removeFirst();
			switch(currentCmd.cmd) {
			case Command.AllCmds.CREATE:
				Thread a=new Thread(new Room());
				a.start();
				Main.rooms.put(currentCmd.value, a);
				break;
			case JOIN:
				//TODO
				break;
			case LIST:
				
				break;
			case MSG:
				break;
			case NICK:
				break;
			case SHOW:
				break;
			case WHERE:
				break;
			default:
				break;
				
			}
			lock.unlock();
		}
	}

}
