package lesson151017;

import java.util.concurrent.atomic.AtomicInteger;

import utils.Utils;

public class RaceConditionWithAtomics {

	private static final class Task implements Runnable {
		@Override
		public void run() {
			while (true) {
				int value = count.incrementAndGet();
				System.out.println(value);
				Utils.pause(1000);
			}
		}
	}

	private static AtomicInteger count = new AtomicInteger();

	public static void main(String[] args) {

		new Thread(new Task()).start();
		new Thread(new Task()).start();

	}

}
