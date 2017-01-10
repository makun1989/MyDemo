package com.makun.chapter21;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	private final static int GROUP_SIZE = 5;
	private final static Random random = new Random();

	public static void main(String[] args) throws InterruptedException {
		processOneGroup("分组1");
		processOneGroup("分组2");
	}

	private static void processOneGroup(final String groupName) throws InterruptedException {
		final CountDownLatch preCountDown = new CountDownLatch(GROUP_SIZE);
		final CountDownLatch startCountDown = new CountDownLatch(1);
		final CountDownLatch endCountDown = new CountDownLatch(GROUP_SIZE);

		System.out.println("分组" + groupName + " 比赛开始=========================>");
		for (int i = 0; i < GROUP_SIZE; i++) {
			new Thread(String.valueOf(i)) {
				public void run() {
					preCountDown.countDown();//代表准备就绪

					System.out.println("我是线程组:" + groupName + ",第" + this.getName() + "号线程,我已准备就绪");
//					startCountDown.countDown();

					try {
						startCountDown.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
//						System.out.println("kdfakfjoaif");
						Thread.sleep(Math.abs(random.nextLong()) % 1000);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("我是线程组" + groupName + ",第" + this.getName() + "号线程,我执行完成了.");
					endCountDown.countDown();

				};
			}.start();
		}

		preCountDown.await();
		System.out.println("各就各位,预备!");
		startCountDown.countDown();
		endCountDown.await();

		System.out.println("比赛结束");
	}
}
