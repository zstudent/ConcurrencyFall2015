package lesson151017;

import utils.Utils;

public class SingleThreadExecutor {
	
	private BlockingQueue<Runnable> queue = new BlockingQueue<>();
	
	private class Runner implements Runnable {

		@Override
		public void run() {
			while (true) {
				queue.take().run();
			}
		}
	}

	Thread t = new Thread(new Runner());

	public SingleThreadExecutor() {
		t.start();
	}

	public void execute(Runnable task) {
		queue.put(task);
	}

	public static void main(String[] args) {

		SingleThreadExecutor worker = new SingleThreadExecutor();

		Utils.pause(3000);

		worker.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello!");
			}
		});

	}

}
