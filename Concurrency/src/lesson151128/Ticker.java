package lesson151128;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ticker {
	
	public static void main(String[] args) {
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		
		service.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				
				System.out.println("tick");
				
			}
			
			
		}, 0, 1, TimeUnit.SECONDS);
		
	}

}
