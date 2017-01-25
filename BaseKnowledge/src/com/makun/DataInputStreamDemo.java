package com.makun;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamDemo {
	public static void main(String[] args) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("a.txt"));
		dos.writeInt(20);
		dos.writeDouble(22.39);
		dos.close();
		
		DataInputStream dis=new DataInputStream(new FileInputStream("a.txt"));
		int readInt=dis.readInt();
		double db=dis.readDouble();
		System.out.println(readInt);;
		System.out.println(db);
	}
}
