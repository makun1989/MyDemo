package com.makun.chapter18;

import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
	private static String file = "a.txt";

	public static void main(String[] args) throws Exception {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
//		for (int i = 0; i < 7; i++) {
//			raf.writeDouble(i * 1.414);
//		}
//		raf.writeUTF("The end of the file.");
//		raf.close();
		
		
		
//		display();
//		raf = new RandomAccessFile(file, "rw");
//		raf.seek(5 * 8);
//		raf.writeDouble(47.001);
//		raf.close();
//		display();
		
		byte[] buf=new byte[100];
		FileInputStream fis=new FileInputStream(file);
		fis.read(buf);
		System.out.println(buf.length);
		for(int i=0;i<20;i++){
			System.out.println(buf[i]);
		}
		
		
	}

	public static void display() throws Exception {

		RandomAccessFile raf = new RandomAccessFile(file, "r");
		for (int i = 0; i < 7; i++) {
			System.out.println("Value " + i + ":" + raf.readDouble());
		}
		System.out.println(raf.readUTF());
		raf.close();
	}
}
