package graph;

public class Node<T> {
	T t;
	public Node(T t) {
		this.t = t;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return t.equals(((Node<T>)obj).t);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return t.hashCode();
	}
}
