package com.imooc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		System.out.println("***********Client***********");
		while (true) {
			InetAddress local=InetAddress.getLocalHost();
			Socket socket=new Socket(local, 8888);
			OutputStream outputStream=socket.getOutputStream();
			PrintWriter printWriter=new PrintWriter(outputStream);
			System.err.print("Tom:");
			Scanner in=new Scanner(System.in);
			String words=in.nextLine();
			
			printWriter.write(words);
			printWriter.flush();
			socket.shutdownOutput();
			
			InputStream inputStream=socket.getInputStream();
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			String info=null;
			while ((info=bufferedReader.readLine())!=null){
				System.out.println("Jerry:"+info);
			}
			socket.shutdownInput();
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			
			printWriter.close();
			outputStream.close();
			socket.close();
		}
	}

}
