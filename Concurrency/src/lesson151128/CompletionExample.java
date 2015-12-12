package lesson151128;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utils.Utils;

public class CompletionExample {

	static final private Random random = new Random();
	
	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			Utils.pause(5000 + random.nextInt(5000));
			return random.nextInt(1000000);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		List<Future<Integer>> results = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			results.add(service.submit(new Task()));
		}
		
		int sum = 0;
		
		for (Future<Integer> future : results) {
			try {
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
