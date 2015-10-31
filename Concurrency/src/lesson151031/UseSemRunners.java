package lesson151031;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import utils.Utils;

public class UseSemRunners {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Semaphore latch = new Semaphore(0);
		
		executorService.execute(new SemRunner(latch));
		executorService.execute(new SemRunner(latch));
		executorService.execute(new SemRunner(latch));
		executorService.execute(new SemRunner(latch));
		
		Utils.pause(1000);
		System.out.println("Ready...");
		Utils.pause(1000);
		System.out.println("Steady...");
		Utils.pause(1000);
		System.out.println("Go!!!");
		latch.release(4);
		
	}
	
}
