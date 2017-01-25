package com.makun.chapter18;

import java.io.*;


public class BufferedInputFile {
	public static void main(String[] args) throws Exception{
		
	}
	
	public static String read(String  filename)throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(filename));
		String aline;
		StringBuffer sb=new StringBuffer();
		while((aline=br.readLine())!=null){
			sb.append(aline+"\n");
		}
		return sb.toString();
	}


}
