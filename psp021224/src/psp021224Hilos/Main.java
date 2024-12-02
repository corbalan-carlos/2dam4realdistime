package psp021224Hilos;

import java.io.IOException;
import java.nio.channels.Pipe;

public class Main {
	static public MesaPasteles mesa;
	static private Pipe pipe;
	static public Gandalf g; 
	static public Frodo f;
	public static void main(String[] args) throws IOException {
		pipe=Pipe.open();
		g= new Gandalf();
		f=new Frodo();
		mesa=new MesaPasteles(pipe.source(),pipe.sink());
		new Thread(g).start();
		new Thread(f).start();
		new Thread(new HobbitAyudante()).start();
		new Thread(new HobbitAyudante()).start();
		new Thread(new HobbitAyudante()).start();
		
	}
}
