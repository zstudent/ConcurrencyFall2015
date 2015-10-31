package lesson151031;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLExample {
	
	static class Dict {
		
		Map<String, String> data = new HashMap<String, String>();
		ReadWriteLock rwl = new ReentrantReadWriteLock(true);
		Lock readLock = rwl.readLock();
		Lock writeLock = rwl.writeLock();
		
		public void put(String key, String value) {
			writeLock.lock();
			try {
				data.put(key, value);
			} finally {
				writeLock.unlock();
			}
		}
		
		public String get(String key) {
			readLock.lock();
			try {
				return data.get(key);
			} finally {
				readLock.unlock();
			}
		}
		
	}

}
