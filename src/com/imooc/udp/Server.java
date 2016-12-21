package com.imooc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		System.out.println("********************Server******************");
		DatagramSocket socket=new DatagramSocket(8848);
		byte[] data=new byte[1024];
		//用于接收客户端数据
		DatagramPacket packet=new DatagramPacket(data, data.length);
		socket.receive(packet);
		
		String info=new String(data, 0, packet.getLength());
		System.out.println(info);
		
		InetAddress inetAddress=packet.getAddress();
		int port=packet.getPort();
		Scanner in=new Scanner(System.in);
		String response=in.nextLine();
		DatagramPacket resMsg=new DatagramPacket(response.getBytes(), response.getBytes().length,inetAddress,port);
		socket.send(resMsg);
		
		socket.close();
	}

}
