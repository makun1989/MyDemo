package com.makun.chapter18.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class UsingBuffer {
	public static void main(String[] args)throws IOException {
		FileInputStream fis=new FileInputStream(new File("/home/makun/a.txt"));
		FileOutputStream fos=new FileOutputStream(new File("/home/makun/b.txt"));
		FileChannel in = fis.getChannel();
		FileChannel out = fos.getChannel();
		ByteBuffer buffer =ByteBuffer.allocate(1000);
		
		in.read(buffer);
		display(buffer);
		out.write(buffer);
		
		
		out.close();
		in.close();
		fos.close();
		fis.close();
	}
	
	private static void display(ByteBuffer buffer){
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		
	}
}	
