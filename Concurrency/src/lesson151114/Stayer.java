package lesson151114;

import java.util.Random;

import utils.Utils;

public class Stayer implements Runnable {
	
	static final Random random = new Random();
	private Barrier barrier;
	
	public Stayer(Barrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println("start " + this);
		Utils.pause(5000 + random.nextInt(5000));
		System.out.println("finished " + this);
		barrier.await();
		System.out.println("passed barrier " + this);
	}

}
