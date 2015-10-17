package lesson151017;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue<T> {
	private Queue<T> items = new LinkedList<>();
	
	public void put(T item) {
		synchronized (items) {
			items.offer(item);
			items.notify();
		}
	}
	
	public T take() {
		synchronized (items) {
			while (items.isEmpty()) {
				try {
					items.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return items.poll();
		}
	}
	
}