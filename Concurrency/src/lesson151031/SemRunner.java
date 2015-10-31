package lesson151031;

import java.util.concurrent.Semaphore;

class SemRunner implements Runnable {

	private Semaphore sem;

	public SemRunner(Semaphore latch) {
		this.sem = latch;
	}

	@Override
	public void run() {
		System.out.println("Runner " + this + " awaits");
		sem.acquireUninterruptibly();
		System.out.println("Runner " + this + " runs!");
	}

}