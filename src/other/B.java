package other;

import java.util.LinkedList;

public class B {
	public void print(){
		System.out.println("B");
	}
	public void print1(){
		System.out.println("B1");
	}
	static char[] toCharBits(long num, int size) {
		char[] charBits = new char[size];
		for (int i = size-1; i >= 0; --i) {
		    charBits[i] = (num & 1) == 0 ? '0' : '1';
		    num >>>= 1;
		}	
		return charBits;
		}
	public static int foo(int x){
		return x & -x;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(foo((int) (Math.pow(2, 31) - 3)));
		int i = (int) (Math.pow(2, 31) - 3);
		System.out.println(toCharBits(-i,32));
		System.out.println(toCharBits(-3,32));
		LinkedList<Integer> a;
	}
}
