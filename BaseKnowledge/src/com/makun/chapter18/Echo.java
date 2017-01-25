package com.makun.chapter18;

import java.io.*;


public class Echo {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String aline; 
		while((aline=br.readLine())!="bye"){
			System.out.println(aline);
		}
	}
}
