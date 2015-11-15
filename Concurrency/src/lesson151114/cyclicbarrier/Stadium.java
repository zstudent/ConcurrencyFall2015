package lesson151114.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Stadium {

	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
			@Override
			public void run() {
				System.out.println("Hurray Cyclic! " + Thread.currentThread());
			}
		});
		
		new Thread(new Stayer(barrier)).start();
		new Thread(new Stayer(barrier)).start();
		new Thread(new Stayer(barrier)).start();
		new Thread(new Stayer(barrier)).start();
		
	}
	
}
