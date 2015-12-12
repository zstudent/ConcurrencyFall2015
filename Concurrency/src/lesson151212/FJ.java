package lesson151212;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FJ {

	static class Fibonacci extends RecursiveTask<Integer> {

		final int n;

		Fibonacci(int n) {
			this.n = n;
		}

		@Override
		public Integer compute() {
			if (n <= 1) {
				return n;
			}
			Fibonacci f1 = new Fibonacci(n - 1);
			f1.fork();
			Fibonacci f2 = new Fibonacci(n - 2);
			return f2.compute() + f1.join();
		}
	}

	public static void main(String[] args) {

		ForkJoinPool pool = new ForkJoinPool(30);
		
		long start = System.nanoTime();
		Integer result = pool.invoke(new Fibonacci(50));
		long stop = System.nanoTime();
		
		
		
		System.out.println("Elapsed = " + (stop - start) / 1000000);
		

	}

}
