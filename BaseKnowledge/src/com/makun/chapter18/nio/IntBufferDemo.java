package com.makun.chapter18.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
	public static void main(String[] args) {
		final int  SIZE=200;
		ByteBuffer bb=ByteBuffer.allocate(SIZE);
		IntBuffer ib =bb.asIntBuffer();
		ib.put(new int[]{
			20,33,95,287,773	
		});
		
		ib.put(209388);
		ib.flip();
		while(ib.hasRemaining()){
			System.out.println(ib.get());
		}
	}
}
