package com.makun.chapter18.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("src/com/makun/chapter18/nio/lib/abc.txt");

		FileLock lock = fos.getChannel().tryLock();

		if (lock != null) {
			System.out.println("Lock file.");
			TimeUnit.SECONDS.sleep(2);
			lock.release();
			System.out.println("Release lock.");
		}
		fos.close();

	}
}
