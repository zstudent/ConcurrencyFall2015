package lesson151128;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import utils.Utils;

public class ShutdownExamples {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.execute(new Runnable() {
			
			@Override
			public void run() {
				Utils.pause(3000);
				System.out.println("finished");
			}
		});
		
		service.shutdown();
		
		service.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Am I late?");
			}
		});
		
		System.out.println("the end");
		
	}
	
	

}
