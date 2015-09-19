package lesson150919;

public class FirstThread {
	
	static class T1 extends Thread  {
		
		@Override
		public void run() {
			System.out.println("Hi there");
			int i = 0;
			while (true) {
				i++;
				if (i % 100_000_000 == 0 ) {
					System.out.println(i);
				}
			}
		}
		
	}
	
	static class T2 implements Runnable {

		@Override
		public void run() {
			System.out.println("hi!");
			try {
				Thread.sleep(1000000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread());
		
		new Thread().start();
		
//		new T1().start();
		
		new Thread(new T2()).start();
		
	}
	
}
