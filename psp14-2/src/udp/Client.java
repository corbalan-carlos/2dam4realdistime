package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		try (Scanner sc=new Scanner(System.in);DatagramSocket sck=new DatagramSocket()) {
			sck.connect(InetAddress.getByName("localhost"), 6666);
			byte[] message1=new byte[256];
			byte[] message2=new byte[256];
			byte[] message3=new byte[256];
			message1[0]=0b0100000;
			message1[1]=(byte) 0xc0;
			message1[2]=(byte) 0xA8;
			message1[3]=(byte) 0x01;
			message1[4]=(byte) 0x01;
			String s="micasa.com";
			byte[] buffer=s.getBytes();
			for (int i=0;buffer.length<i;i++) {
				message1[i+4]=buffer[i];
			}
			sck.send(new DatagramPacket(message1,256));
message2[0]=(byte) 0b10000000;
			message2[1]=(byte) 0xc0;
			message2[2]=(byte) 0xA8;
			message2[3]=(byte) 0x01;
			message2[4]=(byte) 0x01;	
			for (int i=0;buffer.length<i;i++) {
				message2[i+4]=buffer[i];
			}	
			sck.send(new DatagramPacket(message2,256));
			DatagramPacket packet=new DatagramPacket(message3,256);
			sck.receive(packet);
			
		}
	}

}
