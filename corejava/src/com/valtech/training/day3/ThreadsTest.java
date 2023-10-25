package com.valtech.training.day3;

public class ThreadsTest {

	public static class PrinterThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread() + "printer" + i);
			}
		}

	}

	public static class PrinterThreadByInterface implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread() + "runnable" + i);

			}
		}

		public static void main(String[] args) {
			new PrinterThread().start();
			new PrinterThread().start();
			// for runnable
			new Thread(new PrinterThreadByInterface()).start();
			new Thread(new Runnable() {
				public void run() {
					for (int i = 0; i < 10; i++) {
						System.out.println(Thread.currentThread() + "run1" + i);
					}

				}
			}).start();

			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread() + "main" + i);

			}
		}
	}
}
