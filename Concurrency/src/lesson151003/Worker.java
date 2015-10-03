package lesson151003;

import utils.Utils;

public class Worker {

	private class Runner implements Runnable {

		@Override
		public void run() {
			while (hasNextTask()) {
				Runnable task = getNextTask();
				task.run();
			}
		}

		private Runnable getNextTask() {
			Runnable tmp = task;
			task = null;
			return tmp;
		}

		private boolean hasNextTask() {
			while (task == null) {
				Utils.pause(100);
			}
			return true;
		}

	}

	Thread t = new Thread(new Runner());
	private Runnable task;
	
	public Worker() {
		t.start();
	}
	
	public void execute(Runnable task) {
		this.task = task;
	}
	
	public static void main(String[] args) {
		
		Worker worker = new Worker();
		
		Utils.pause(3000);
		
		worker.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello!");
			}
		});
		
	}
	
}
