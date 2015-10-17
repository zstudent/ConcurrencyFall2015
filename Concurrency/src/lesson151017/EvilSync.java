package lesson151017;

import java.util.Vector;

import utils.Utils;

public class EvilSync {
	
	public static void main(String[] args) {
		
		final Vector<String> v = new Vector<>();
		
		Thread thread = new Thread(new Runnable() {  // Vector v = v;
			
			@Override
			public void run() {
				System.out.println("start");
				v.addElement("one");
				System.out.println(v);
				v.addElement("two");
				System.out.println(v);
				v.addElement("three");
				System.out.println(v);
			}
		});
		
		synchronized (v) {
			thread.start();
			while (true) {
				Utils.pause(1000);
				System.out.println("hoho");
			}
		}
		
		
		
	}

}
