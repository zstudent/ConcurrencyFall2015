package lesson151114;

public class Stadium {

	public static void main(String[] args) {
		
		Barrier barrier = new Barrier(4, new Runnable() {
			@Override
			public void run() {
				System.out.println("Hurray!");
			}
		});
		
		new Thread(new Stayer(barrier)).start();
		new Thread(new Stayer(barrier)).start();
		new Thread(new Stayer(barrier)).start();
		new Thread(new Stayer(barrier)).start();
		
		barrier.waitUntilDone();
	}
	
}
