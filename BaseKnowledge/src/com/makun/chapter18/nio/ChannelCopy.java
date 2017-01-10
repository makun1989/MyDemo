package com.makun.chapter18.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
	public static void main(String[] args)throws Exception {
		FileChannel in = new FileInputStream("src/com/makun/chapter18/nio/lib/abc.txt").getChannel();
		FileChannel out = new FileOutputStream("src/com/makun/chapter18/nio/lib/def.txt").getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		while(in.read(buffer)!=-1){
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
		
	}
}
