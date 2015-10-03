package lesson151003;

import utils.Utils;

public class UseJoin {
	
	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("start");
			Utils.pause(20000);
			System.out.println("stop");
		}
		
	}
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new Task());
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("finished");
		
	}

}
