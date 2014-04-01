package linkedList;

/**
 * 链表及操作
 * @author chenjun
 *
 */
public class LinkedList{
	/**
	 * 链表反转
	 * @param head
	 * @return
	 */
	public static <T> Node<T> reverseLinkedList(Node<T> head){
		if(head == null)
			return head;
		Node<T> p1 = head;
		Node<T> p = p1.next;
		head.next = null;
		while(true){			
			if(p == null)
				break;
			Node<T> q = p.next;
			p.next = p1;
			p1 = p;
			p = q;
		}
		return p1;		
	}
	
	/**
	 * 创建链表
	 * @param array
	 * @return
	 */
	public  static <T> Node<T> createLinkedList(T[] array){
		if(array == null)
			return null;
		Node<T> head = null,tail = null;	
		for(int i = 0; i< array.length; i++){
			Node<T> p = new Node<>(array[i]);
			if(head == null)
				head = p;
			else
				tail.next = p;
			tail = p;
		}
		return head;
	}
	
	/**
	 * 输出链表
	 * @param head
	 */
	public static <T> void printNodes(Node<T> head){
		if(head == null){
			System.out.println("无元素");
			return;
		}
		while(head != null){
			System.out.print(head.t + "\t");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		Integer[] array = null;
		Node<Integer> head = createLinkedList(array);
		printNodes(head);
		System.out.println();
		head = reverseLinkedList(head);
		printNodes(head);
	}
	
}
