package lesson150919;

public class Daemons {
	
	static class Ticker implements Runnable {
		
		@Override
		public void run() {
			int x = 0;
			while (true) {
				System.out.println("x=" + (x++));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new Ticker(), "Ticker");
		thread.setDaemon(true);
		thread.start();
		
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
