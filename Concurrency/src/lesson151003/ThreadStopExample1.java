package lesson151003;

import utils.Utils;

public class ThreadStopExample1 {
	
	static class Task implements Runnable {

		volatile private boolean running;

		@Override
		public void run() {
			int c = 0;
			running = true;
			while (running) {
				c++;
//				if (c % 1_000_000_000 == 0) {
//					System.out.println(c);
//				}
			}
			System.out.println(c);
		}
		
		public void stop() {
			running = false;
		}
		
	}
	
	public static void main(String[] args) {
		
		Task task = new Task();
		Thread t = new Thread(task);
		t.start();
		
		Utils.pause(3000);
		
		task.stop();
		
	}

}
