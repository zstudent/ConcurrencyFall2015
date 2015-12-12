package lesson151128;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utils.Utils;

public class ExecutorCompletionServiceExample {

	static final private Random random = new Random();

	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			Utils.pause(5000 + random.nextInt(5000));
			return random.nextInt(1000000);
		}

	}

	public static void main(String[] args) {

		ExecutorService coreService = Executors.newFixedThreadPool(4);
		ExecutorCompletionService<Integer> ecs = new ExecutorCompletionService<>(
				coreService);

		for (int i = 0; i < 20; i++) {
			ecs.submit(new Task());
		}

		int sum = 0;

		for (int i = 0; i < 20; i++) {
			try {
				Future<Integer> future = ecs.take();
				System.out.println(future.isDone());
				Integer data = future.get();
				sum += data;
				System.out.println(data);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Total: " + sum);

	}

}
