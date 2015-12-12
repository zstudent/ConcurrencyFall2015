package lesson151128;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import utils.Utils;

public class TimeoutExample {
	
	public static void main(String[] args) {
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		
		final Future<?> taskFuture = service.submit(new Runnable() {
			
			@Override
			public void run() {
				try {
					Utils.pause(100000);
				} finally {
					System.out.println("finished!");
				}
			}
		});
		
		service.schedule(new Runnable() {

			@Override
			public void run() {
				if (!taskFuture.isDone()) {
					taskFuture.cancel(true);
				}
			}
			
		}, 5, TimeUnit.SECONDS);
		
		System.out.println(taskFuture.isCancelled());
		
	}

}
