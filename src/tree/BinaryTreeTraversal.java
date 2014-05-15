package tree;

import java.util.LinkedList;

/**
 * �������������ݹ���ǵݹ�ʵ�֡�
 * @author chenjun
 *
 */
public class BinaryTreeTraversal {
	/**
	 * ����������ݹ�ʵ�֡�
	 * @param root
	 */
	public static <T> void preOrder(Node<T> root){
		if(null == root)
			return;
		System.out.print(root.t + "  ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	/**
	 * ����������ǵݹ�ʵ�֡�
	 * @param root
	 */
	public static <T> void preOrderNoRecu(Node<T> root){
		LinkedList<Node<T>> nodes = new LinkedList<>();
		while(!nodes.isEmpty() || root != null){
			if(root != null){
				System.out.print(root.t + "  ");
				nodes.addFirst(root);
				root = root.left;
			}else{
				Node<T> tmp = nodes.removeFirst();
				root = tmp.right;
			}
		}
	}
	
	/**
	 * ����������ݹ�ʵ�֡�
	 * @param root
	 */
	public static <T> void inOrder(Node<T> root){
		if(null == root)
			return;
		inOrder(root.left);
		System.out.print(root.t + "  ");
		inOrder(root.right);
	}
	
	/**
	 * ����������ǵݹ�ʵ�֡�
	 * @param root
	 */
	public static <T> void inOrderNoRecu(Node<T> root){
		LinkedList<Node<T>> nodes = new LinkedList<>();
		while(!nodes.isEmpty() || root != null){
			if(root != null){
				nodes.addFirst(root);
				root = root.left;
			}else{
				Node<T> tmp = nodes.removeFirst();
				System.out.print(tmp.t + "  ");
				root = tmp.right;
			}
		}
	}
	
	/**
	 * ����������ݹ�ʵ�֡�
	 * @param root
	 */
	public static <T> void postOrder(Node<T> root){
		if(null == root)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.t + "  ");		
	}
	
	/**
	 * ����������ǵݹ�ʵ�֡�
	 * @param root
	 */
	public static <T> void postOrderNoRecu(Node<T> root){
		LinkedList<Node<T>> nodeStack = new LinkedList<>();
		LinkedList<Node<T>> nodesReverse = new LinkedList<>();
		while(!nodeStack.isEmpty() || root != null){
			if(root != null){
				nodesReverse.addFirst(root);
				nodeStack.addFirst(root);
				root = root.right;
			}else{
				Node<T> tmp = nodeStack.removeFirst();
				root = tmp.left;
			}
		}
		for (Node<T> node : nodesReverse) {
			System.out.print(node.t + "  ");
		}
	}
	
	public static void main(String[] args) {
		Integer[] array = {1,2,4,null,null,5,null,null,3,6,null,null,7};
		Node<Integer> root = Tree.createTree(array);
		postOrder(root);
		System.out.println();
		postOrderNoRecu(root);
	}
}
