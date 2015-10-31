package lesson151031;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class LockExample1 {

	static Lock lock = new ReentrantLock();

	public static void main(String[] args) {

		class Task implements Runnable {

			@Override
			public void run() {
				System.out.println("trying to lock");
				// try {
				// lock.lockInterruptibly();
				// } catch (InterruptedException e) {
				// System.out.println("interrupted!");
				// return;
				// }
				// try {
				// boolean success = lock.tryLock(3,TimeUnit.SECONDS);
				// if (!success) {
				// System.out.println("timeout");
				// return;
				// }
				// } catch (InterruptedException e) {
				// System.out.println("interrupted");
				// return;
				// }
				boolean success = lock.tryLock();
				if (!success) {
					System.out.println("couldn't get lock");
					return;
				}
				try {
					System.out.println("got lock!");
				} finally {
					lock.unlock();
					System.out.println("unlocked!");
				}
			}

		}

		lock.lock();

		Thread thread = new Thread(new Task());
		thread.start();

		Utils.pause(5000);

		// thread.interrupt();

	}

}
