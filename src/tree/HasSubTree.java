package tree;

public class HasSubTree {
	public static <T> boolean hasSubTree(Node<T> parent,Node<T> child){
		if(parent == null || child == null)
			return false;
		if(isEqual(parent, child))
			return true;
		return hasSubTree(parent.left,child) || hasSubTree(parent.right, child);
	}
	
	private static <T> boolean isEqual(Node<T> parent,Node<T> child){
		if(child == null)
			return true;
		if(parent == null)
			return false;
		if(!parent.equals(child))
			return false;		
		return isEqual(parent.left,child.left) && isEqual(parent.right, child.right);
	}
	
	public static void main(String[] args) {
		Integer[] array = {1,2,4,null,null,5,null,null,3,6,null,null,7};
		Integer[] array1 = {2,4,null,null,6,null,null};
		Node<Integer> parent = Tree.createTree(array);
		Tree.i = 0;
		Node<Integer> child = Tree.createTree(array1);
		System.out.println(hasSubTree(parent, child));
	}
}
