package lesson151003;

import utils.Utils;

public class ThreadStopExample2 {
	
	static class Task implements Runnable {

		@Override
		public void run() {
			int c = 0;
			while (!Thread.currentThread().isInterrupted()) {
				c++;
				if (c % 1_000_000_000 == 0) {
					System.out.println(c);
				}
			}
//			System.out.println(c);
		}
		
	}
	
	public static void main(String[] args) {
		
		Task task = new Task();
		Thread t = new Thread(task);
		t.start();
		
		Utils.pause(3000);
		
		t.interrupt();
		
	}

}
