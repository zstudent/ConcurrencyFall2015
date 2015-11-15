package lesson151114.executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Example3 {

	public static void main(String[] args) {

		final ArrayBlockingQueue<Callable<Integer>> queue = 
				new ArrayBlockingQueue<Callable<Integer>>(10);

		class Task implements Callable<Integer> {

			@Override
			public Integer call() throws Exception {
				try {

					int x = 0;
					for (int i = 0; i < 1000000000; i++) {
						x += i;
					}
					return x;
				} finally {
					queue.put(this);
				}
			}
		};
		
		for (int i = 0; i < 10; i++) {
			try {
				queue.put(new Task());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		ExecutorService service = Executors.newCachedThreadPool();

		while (true) {
			try {
				service.submit(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
