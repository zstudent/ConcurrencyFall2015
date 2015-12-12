package lesson151212;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import utils.Utils;

public class FJ0 {
	
	static class Task extends RecursiveAction {
		
		private int level;

		public Task(int level) {
			this.level = level;
		}

		@Override
		protected void compute() {
			
			System.out.println(this + " " + level);
			
			Utils.pause(1000);
			
			if (level == 0) {
				return;
			}
			
			Task subTask1 = new Task(level-1);
			Task subTask2 = new Task(level-1);
			
			invokeAll(Arrays.asList(subTask1, subTask2));
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool(200);
		
		
		pool.invoke(new Task(5));
		
	}

}
