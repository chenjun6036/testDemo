package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestVolatile extends Thread{
	public static volatile int n = 0;
	public static volatile FinalHolder m = new FinalHolder(0);
//	public static  int n = 0;
	
//	public static synchronized void inc(){
//		n++;
//	}
	public void run(){
		for(int i = 0; i < 10; i++){			
			try {
//				inc();
//				n++;
				m = new FinalHolder(m.get()+1);
				sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Thread[] threads = new TestVolatile[100];
		for(int i = 0; i < threads.length; i++)
			threads[i] = new TestVolatile();
		for(int i = 0; i < threads.length; i++)
			threads[i].start();
		for(int i = 0; i < threads.length; i++)
			threads[i].join();
		System.out.println(m.get());
		Arrays.sort(new Integer[10]);
		Collections.unmodifiableList(new ArrayList<>());
	}
	
}
