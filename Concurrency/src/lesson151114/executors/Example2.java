package lesson151114.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import utils.Utils;

public class Example2 {

	public static void main(String[] args) {

		final Semaphore sem = new Semaphore(10);

		Callable<Integer> task = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				try {

					int x = 0;
					for (int i = 0; i < 1000000000; i++) {
						x += i;
					}
					return x;
				} finally {
					sem.release();
				}
			}
		};

		ExecutorService service = Executors.newCachedThreadPool();

		while (true) {
			sem.acquireUninterruptibly();
			service.submit(task);
		}

	}

}
