package com.imooc.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class inetaddress {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress inetaddress=InetAddress.getLocalHost();
		byte[] address=inetaddress.getAddress();
		System.out.println(Arrays.toString(address));
//		for(int i=0;i<address.length;i++){
//			System.err.print(address[i]);
//		}
		System.out.println("�������:"+inetaddress.getHostName());
		System.out.println("IP��ַ:"+inetaddress.getHostAddress());
	}

}
