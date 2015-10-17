package lesson151017;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

	static class Sum {
		int x = 0;
		int y = 100;
		private Lock mutex = new ReentrantLock();

		public void change(int amount) {
			mutex.lock();
			try {
				x += amount;
				y -= amount;
				a();
			} finally {
				mutex.unlock();
			}
			
		}

		private void a() {
			// TODO Auto-generated method stub
			
		}

	}

}
