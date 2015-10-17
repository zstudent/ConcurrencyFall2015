package lesson151017;

import java.util.LinkedList;
import java.util.Queue;

class BoundedBlockingQueue<T> {
	private Queue<T> items = new LinkedList<>();
	private int capacity;
	
	public BoundedBlockingQueue(int capacity) {
		this.capacity = capacity;
	}
	
	public void put(T item) {
		synchronized (items) {
			while (items.size() == capacity) {
				try {
					items.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
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