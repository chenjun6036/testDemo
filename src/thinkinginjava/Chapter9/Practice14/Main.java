package thinkinginjava.Chapter9.Practice14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main implements D {
	
	private int a = 3;

	@Override
	public void a1() {
		// TODO Auto-generated method stub
		System.out.println("a1");
	}

	@Override
	public void a2() {
		// TODO Auto-generated method stub
		System.out.println("a2");
	}

	@Override
	public void b1() {
		// TODO Auto-generated method stub
		System.out.println("b1");
	}

	@Override
	public void b2() {
		// TODO Auto-generated method stub
		System.out.println("b2");
	}

	@Override
	public void c1() {
		// TODO Auto-generated method stub
		System.out.println("c1");
	}

	@Override
	public void c2() {
		// TODO Auto-generated method stub
		System.out.println("c2");
	}

	@Override
	public void d1() {
		// TODO Auto-generated method stub
		System.out.println("d");
	}
	public void a(A a){
		a.a1();
		a.a2();
		System.out.println("---");
	}
	
	public void b(B b){
		b.b1();
		b.b2();
		System.out.println("---");
	}
	
	public void c(C c) {
		c.c1();
		c.c2();
		System.out.println("---");
	}
	
	public void d(D d) {
		d.d1();
	}
	
	public void output(Main m){
		System.out.println("-------m");
		System.out.println(m.a);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Main> l = new ArrayList<>();
		Iterator<Main> i = l.iterator();
	}

}
