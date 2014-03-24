package tree;

public class Node<T> {
	public T t;
	public Node<T> left,right;
	public int leftLen, rightLen;
	Node(T t){
		this.t = t;
	}
}
