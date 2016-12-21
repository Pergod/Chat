package com.imooc.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
		
public class Server {

	public static void main(String[] args) throws IOException {
			System.out.println("***********Server***********");
			ServerSocket serverSocket=new ServerSocket(8888);
			Socket socket=null;
			while (true) {
				socket=serverSocket.accept();
				ServerThread serverThread=new ServerThread(socket);
				serverThread.start();
				String threadName=serverThread.getName();
				System.out.println(threadName);
			}
	}

}
