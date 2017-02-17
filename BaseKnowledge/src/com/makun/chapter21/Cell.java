package com.makun.chapter21;

public class Cell {
	private long value;

	public Cell(long value) {
		this.value = value;
	}

	public synchronized long getValue() {
		return value;
	}

	public synchronized void setValue(long value) {
		this.value = value;
	}

	public synchronized void swap(Cell other) {
		long t = getValue();
		long v = other.getValue();
		setValue(v);
		other.setValue(t);
	}

	public static void main(String args[]) throws Exception {
		//
		final Cell c1 = new Cell(100);
		final Cell c2 = new Cell(200);

		//
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				long count = 0;
				try {
					while (true) {
						c1.swap(c2);
						count++;
						if (count % 100 == 0) {
							System.out.println("thread1's current progress: " + count);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		t1.setName("thread1");

		//
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				long count = 0;
				try {
					while (true) {
						c2.swap(c1);
						count++;
						if (count % 100 == 0) {
							System.out.println("thread2's current progress: " + count);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		t2.setName("thread2");

		//
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
