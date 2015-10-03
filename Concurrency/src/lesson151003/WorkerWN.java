package lesson151003;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.Utils;

public class WorkerWN {

	private class Runner implements Runnable {

		@Override
		public void run() {
			while (true) {
				Runnable task = null;
				synchronized (tasks) {
					while (tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					task = tasks.poll();
				}
				task.run();
			}
		}
	}

	Thread t = new Thread(new Runner());
	private Queue<Runnable> tasks = new LinkedList<>();

	public WorkerWN() {
		t.start();
	}

	public void execute(Runnable task) {
		synchronized (tasks) {
			tasks.offer(task);
			tasks.notify();
			// do something
		}
	}

	public static void main(String[] args) {

		WorkerWN worker = new WorkerWN();

		Utils.pause(3000);

		worker.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello!");
			}
		});

	}

}
