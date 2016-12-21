package com.imooc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class url {

	public static void main(String[] args) throws IOException {
		URL url=new URL("http://www.baidu.com");
		URL url2=new URL(url,"1.html");
		System.out.println(url2.getAuthority());
		InputStream inputStream=url.openStream();
		InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
		BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		
	}

}
