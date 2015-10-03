package lesson151003;

import utils.Utils;

public class ThreadStopExample3 {
	
	static class Task implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
