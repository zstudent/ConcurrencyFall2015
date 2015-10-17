package lesson151017;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class SyncBlockLock {

	public static void main(String[] args) {

		final Lock mutex = new ReentrantLock();

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("started");
				try {
					mutex.lockInterruptibly();
					try {
						System.out.println("Haha!");
					} finally {
						mutex.unlock();
					}
				} catch (InterruptedException e) {
					System.err.println("interrupted!");
				}
			}
		});

		mutex.lock();
		try {
			thread.start();
			Utils.pause(1000);
			while (true) {
				Utils.pause(1000);
				System.out.println("hoho");
				thread.interrupt();
//				thread.stop();
			}
		} finally {
			mutex.unlock();
		}

	}

}
