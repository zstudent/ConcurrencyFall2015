package lesson151017;

import utils.Utils;

public class SyncBlock {
	
	public static void main(String[] args) {
		
		final Object mutex = new Object();
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("started");
				synchronized (mutex) {
					System.out.println("Haha!");
				}
			}
		});
		
		synchronized (mutex) {
			thread.start();
			Utils.pause(1000);
			while (true) {
				Utils.pause(1000);
				System.out.println("hoho");
				thread.interrupt();
				thread.stop();
			}
		}
		
		
		
	}

}
