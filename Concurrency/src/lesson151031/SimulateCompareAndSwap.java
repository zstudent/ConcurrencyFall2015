package lesson151031;

public class SimulateCompareAndSwap {
	
	private int value;

	public synchronized int get() {
		return value;
	}
	
	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		int oldValue = value;
		if (oldValue == expectedValue) {
			value = newValue;
		}
		return oldValue;
	}

}
