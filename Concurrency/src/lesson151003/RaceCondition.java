package lesson151003;

import utils.Utils;

public class RaceCondition {

	private static int count = 0;

	static class Counter implements Runnable {

		@Override
		public void run() {
			while (true) {
				Utils.pause(1000);

					inc();
			}
		}

		synchronized private void inc() {
//				synchronized (this) {
			int tmp = count;
//					Utils.pause(100);
			tmp++;
//					Utils.pause(100);
			count = tmp;
//					Utils.pause(100);
			System.out.println("Count = " + count);
//				}
		}

	}

	public static void main(String[] args) {

		Counter task1 = new Counter();
		Counter task2 = new Counter();

		new Thread(task1).start();
		new Thread(task2).start();

	}

}
