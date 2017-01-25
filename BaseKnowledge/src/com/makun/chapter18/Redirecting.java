package com.makun.chapter18;

import java.io.*;

public class Redirecting {
	public static void main(String[] args) throws IOException {
		PrintStream console = System.out;
		BufferedInputStream in=new BufferedInputStream(new FileInputStream("/home/makun/a.txt"));
		PrintStream out =new PrintStream(new FileOutputStream("/home/makun/b.txt"));
		System.setErr(out);
		System.setIn(in);
		System.setOut(out);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String aline;
		while((aline=br.readLine())!=null){
			System.out.println(aline);
		}
		out.close();
		System.setOut(console);
	}
}
