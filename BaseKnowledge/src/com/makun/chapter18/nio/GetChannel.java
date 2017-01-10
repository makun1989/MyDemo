package com.makun.chapter18.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
	private static final int BSIZE=1024;
	public static void main(String[] args) throws Exception{
		FileChannel fc = new FileOutputStream("src/com/makun/chapter18/nio/lib/abc.txt").getChannel();
		fc.write(ByteBuffer.wrap(("hahfjiaofjie").getBytes()));
		fc.close();
		
		
	}
}
