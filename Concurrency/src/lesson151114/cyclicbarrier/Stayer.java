package lesson151114.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import utils.Utils;

public class Stayer implements Runnable {
	
	static final Random random = new Random();
	private CyclicBarrier barrier;
	
	public Stayer(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println("start " + this);
		Utils.pause(5000 + random.nextInt(5000));
		System.out.println("finished " + this);
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("passed barrier " + this);
	}

}
