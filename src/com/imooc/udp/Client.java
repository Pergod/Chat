package com.imooc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		InetAddress inetAddress=InetAddress.getLocalHost();
		Scanner in=new Scanner(System.in);
		String msg=in.nextLine();
		DatagramPacket packet=new DatagramPacket(msg.getBytes(), msg.getBytes().length, inetAddress, 8848);
		DatagramSocket socket=new DatagramSocket();
		socket.send(packet);
		
		byte[] data=new byte[1024];
		//用于接收响应数据
		DatagramPacket getMsg=new DatagramPacket(data, data.length);
		socket.receive(getMsg);
		System.out.println(new String(getMsg.getData(), 0, getMsg.getLength()));
		
		socket.close();
	}

}
