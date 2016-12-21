package com.imooc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
	Socket socket=null;
	
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	
	@Override
	public void run() {
			try {
				
				InputStream inputStream=socket.getInputStream();
				InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
				BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
				
				String info=null;
				while ((info=bufferedReader.readLine())!=null){
					System.out.println("Tom:"+info);
				}
				socket.shutdownInput();
				
				OutputStream outputStream=socket.getOutputStream();
				PrintWriter printWriter=new PrintWriter(outputStream);
				System.err.print("Jerry:");
				Scanner in =new Scanner(System.in);
				String msg=in.nextLine();
				printWriter.write(msg);
				printWriter.flush();
				
				destory(printWriter,outputStream, socket, inputStream, inputStreamReader, bufferedReader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private static void destory(PrintWriter printWriter,OutputStream outputStream,Socket socket, InputStream inputStream,
			InputStreamReader inputStreamReader, BufferedReader bufferedReader) throws IOException {
		
		printWriter.close();
		outputStream.close();
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		
		socket.close();
	}
}
