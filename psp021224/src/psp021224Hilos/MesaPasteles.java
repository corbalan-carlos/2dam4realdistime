package psp021224Hilos;

import java.nio.channels.Pipe;

public class MesaPasteles {
	public Pipe.SourceChannel source;
	public Pipe.SinkChannel sink;
	public MesaPasteles (Pipe.SourceChannel source, Pipe.SinkChannel sink) {
		this.source=source;
		this.sink=sink;
	}
}
