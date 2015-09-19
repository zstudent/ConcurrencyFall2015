package lesson150919;

public class Time {
	
	public static void main(String[] args) {
		
		long start = System.nanoTime();
		
		// do something
		
		long stop = System.nanoTime();
		
		System.out.println("Elapsed = " + (stop - start));
		
	}

}
