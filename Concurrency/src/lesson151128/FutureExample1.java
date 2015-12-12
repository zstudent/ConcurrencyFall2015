package lesson151128;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utils.Utils;

public class FutureExample1 {
	
	public static void main(String[] args) {

		System.out.println("start");
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Future<String> future = service.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Utils.pause(3000);
				return "Hello world!";
			}
		});
		
		System.out.println("waiting for result");
		
		try {
			String result = future.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
