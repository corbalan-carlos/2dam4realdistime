package client;

import java.io.Serializable;

class UDPPacket {
	static final int LENGTH=17;
	private final long clientNow;
	private final byte clientId;
	private final double temp;
	UDPPacket(byte clientId, double temp) {
		this.clientId=clientId;
		this.temp=temp;
		clientNow=System.currentTimeMillis();
	}
	byte[] toByteArr() {
		byte[] result=new byte[17];
		int i=0;
		for (;i<Long.BYTES;i++) {
			result[i]=(byte) (255&(clientNow<<(i*8)));
		}
		result[i]=clientId;
		for (;i-9<Double.BYTES;i++) {
			result[i]=(byte) (255&(Double.doubleToRawLongBits(temp)<<(i-9*8)));
		}
		return result;
	}
}
