package stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/**
 * ģ��ջ���ܹ�ȡ����СԪ�أ�ʱ�临�ӶȾ�ΪO(1)��΢��100��ڶ��⡣
 * @author chenjun
 *
 * @param <T>
 */
public class Stack<T extends Comparable<T>> {
	private LinkedList<T> elements = new LinkedList<>();
	private LinkedList<T> mins = new LinkedList<>();
	
	public Boolean push(T t){
		if(t == null) 
			return false;
		elements.addFirst(t);
		try {
			if(t.compareTo(mins.getFirst())<0){
				mins.addFirst(t);
			}
		} catch (NoSuchElementException  e) {
			mins.addFirst(t);
		}
		return true;		
	}
	
	public T pop() {
		try{
			T t = elements.removeFirst();
			if(t.equals(mins.getFirst())){
				mins.removeFirst();
			}
			return t;
		}catch(NoSuchElementException e){
			System.out.println("ջΪ�գ�popʧ�ܣ�");
			return null;
		}
	}
	
	public T min(){
		return mins.getFirst();
	}
	public void printMins(){
		Iterator<T> it = mins.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"   ");
		}
		System.out.println();
	}
	public void printStack(){
		Iterator<T> it = elements.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"   ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.addLast(2);
		for (Integer integer : ll) {
			System.out.println(integer);
		}
	}
}
