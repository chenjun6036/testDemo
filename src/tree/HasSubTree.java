package tree;

public class HasSubTree {
	public static <T> boolean hasSubTree(Node<T> parent,Node<T> child){
		if(parent == null || child == null)
			return false;
		if(isSubTree(parent, child))
			return true;
		return hasSubTree(parent.left,child) || hasSubTree(parent.right, child);
	}
	
	/**
	 * 判断dst是否是以src根节点开始的子树
	 * @param src
	 * @param dst
	 * @return
	 */
	private static <T> boolean isSubTree(Node<T> src,Node<T> dst){
		if(dst == null)
			return true;
		if(src == null)
			return false;
		if(!src.equals(dst))
			return false;		
		return isSubTree(src.left,dst.left) && isSubTree(src.right, dst.right);
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
