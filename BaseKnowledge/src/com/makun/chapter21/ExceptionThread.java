package com.makun.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable{
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new ExceptionThread());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}
}
