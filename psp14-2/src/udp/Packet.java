package udp;
class Packet {
	protected enum Purpose {
		RESOLVE,
		ADD,
		REMOVE,
		DISCARD;
	}
	public final byte resolveMask=(byte)0b10000000;
	public final byte addMask=0b0100000;
	public final byte delMask=0b0010000;
	public Packet(byte[] buffer) {
		switch (buffer[0]) {
		case resolveMask: this.p=Purpose.RESOLVE;
			break;
		case addMask: this.p=Purpose.ADD;
			break;
		case delMask: this.p=Purpose.REMOVE;
			break;
		default: this.p=Purpose.DISCARD;
		}
		ip[0]=buffer[1];
		ip[1]=buffer[2];
		ip[2]=buffer[3];
		ip[3]=buffer[4];
		StringBuilder strB=new StringBuilder();
		for (int i=4;i<255;i++) {
			char[] toAppend=Character.toChars(buffer[i]<<8+buffer[i+1]);
			strB.append(toAppend);
		}
		s=strB.toString();
	}
	final String s;
	final byte[] ip=new byte[4];
	final Purpose p;
	public Packet(Purpose p,byte[] ip,String direccion) {
		this.p=p;
		this.ip[0]=ip[0];
		this.ip[1]=ip[1];
		this.ip[2]=ip[2];
		this.ip[3]=ip[3];
		this.s=direccion;

	}
	
}
