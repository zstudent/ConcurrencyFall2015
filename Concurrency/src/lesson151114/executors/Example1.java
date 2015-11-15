package lesson151114.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import utils.Utils;

public class Example1 {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		service.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hi there from " + Thread.currentThread());
				Utils.pause(4000);
				System.out.println("finished " + Thread.currentThread());
			}
		});
		
		System.out.println("shutting down");
		service.shutdown();
		System.out.println("finished main");
		
	}

}
