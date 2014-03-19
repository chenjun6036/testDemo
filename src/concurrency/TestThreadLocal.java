package concurrency;

public class TestThreadLocal {
	public static void main(String[] args) {
//		MyThreadLocal myThreadLocal = new MyThreadLocal();
//		TestThread testThread1 = new TestThread(myThreadLocal);
//		TestThread testThread2 = new TestThread(myThreadLocal);
//		TestThread testThread3 = new TestThread(myThreadLocal);
//		testThread1.start();
//		testThread2.start();
//		testThread3.start();
		TestThread t = new TestThread(null);
		t.pr();
	}	
}

class TestThread extends Thread{
	MyThreadLocal threadLocal;
	public TestThread(MyThreadLocal local) {
		threadLocal = local;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 4; i++){
			System.out.println(Thread.currentThread().getName()+"   " + threadLocal.next());			
		}
	}
	
	public void pr(){
		System.out.println(this.getClass().getName());
	}
}


class MyThreadLocal {
//	private int i = 0;
//	public int next(){
//		return i++;
//	}
	
	private ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		};
	};
	
	public Integer next(){
		num.set(num.get() + 1);
		return num.get();
	}
}