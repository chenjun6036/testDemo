package tree;

import java.util.LinkedList;

/**
 * 求二叉树中的距离
 * @author chenjun
 *
 */
public class FindLen {
	public static int maxlen = 0;
	/**
	 * 计算二叉树中节点的最大距离
	 * @param root
	 */
	public static <T> void maxLen(Node<T> root){
		if(root == null)
			return;
		if(root.left == null){
			root.leftLen = 0;
		}
		if(root.right == null){
			root.rightLen = 0;
		}
		if(root.left != null)
			maxLen(root.left);
		if(root.right != null)
			maxLen(root.right);
		
		if(root.left != null){
			if(root.left.leftLen > root.left.rightLen)
				root.leftLen = root.left.leftLen + 1;
			else
				root.leftLen = root.left.rightLen + 1;
		}
		
		if(root.right != null){
			if(root.right.leftLen > root.right.rightLen)
				root.rightLen = root.right.leftLen + 1;
			else
				root.rightLen = root.right.rightLen + 1;
		}
		if(root.leftLen + root.rightLen > maxlen)
			maxlen = root.leftLen + root.rightLen;		
	}
	
	/**
	 * 计算二叉树中节点的最大距离
	 * @param root
	 */
	public static <T> void findMaxLen(Node<T> root) {
		if (root == null)
			return;
		
		if (root.left == null) 
			root.leftLen = 0;
		else
			findMaxLen(root.left);
		
		if (root.right == null)
			root.rightLen = 0;
		else
			findMaxLen(root.right);
		
		if (root.left != null)
			root.leftLen = Math.max(root.left.leftLen + 1, root.left.rightLen + 1);
		
		if (root.right != null)
			root.rightLen = Math.max(root.right.leftLen + 1, root.right.rightLen + 1);
		
		if (root.leftLen + root.rightLen > maxlen)
			maxlen = root.leftLen + root.rightLen;
	} 
	
	
	
	/**
	 * 找出二叉树中指定两节点之间的距离
	 * @param root
	 * @param from
	 * @param to
	 * @return
	 */
	public static <T> int findLen(Node<T> root, T from, T to) {
		LinkedList<Node<T>> pathFrom = new LinkedList<>();
		LinkedList<Node<T>> pathTo = new LinkedList<>();		
		findPath(root, from, to, new LinkedList<Node<T>>(), pathFrom, pathTo);
		while (!pathFrom.isEmpty() && !pathTo.isEmpty() && pathFrom.peekLast().equals(pathTo.peekLast())) {
			pathFrom.pollLast();
			pathTo.pollLast();
		}
		return pathFrom.size() + pathTo.size();
	}
	
	private static <T> void findPath(Node<T> root, T from, T to,LinkedList<Node<T>> stack, LinkedList<Node<T>> pathFrom, LinkedList<Node<T>> pathTo) {
		if (root == null)
			return;
		stack.push(root);
		if(root.t.equals(to))
			pathTo.addAll(stack);
		if(root.t.equals(from))
			pathFrom.addAll(stack);
		findPath(root.left, from, to, stack, pathFrom, pathTo);
		findPath(root.right, from, to, stack, pathFrom, pathTo);
		stack.pop();
	}
	
	/**
	 * 找出二叉树中指定两节点之间的距离
	 * @param root
	 * @param from
	 * @param to
	 * @return
	 */
	public static <T> int findLen1(Node<T> root, T from, T to) {
		LinkedList<Node<T>> pathFrom = new LinkedList<>();
		LinkedList<Node<T>> pathTo = new LinkedList<>();		
		findPath1(root, from, pathFrom);
		findPath1(root, to, pathTo);
		while (!pathFrom.isEmpty() && !pathTo.isEmpty() && pathFrom.peekLast().equals(pathTo.peekLast())) {
			pathFrom.pollLast();
			pathTo.pollLast();
		}
		return pathFrom.size() + pathTo.size();
	}
	
	private static <T> boolean findPath1(Node<T> root, T to,LinkedList<Node<T>> stack) {
		if (root == null)
			return false;
		boolean found = false;
		stack.push(root);
		if(root.t.equals(to))
			return true;
		found = findPath1(root.left, to, stack);
		if (!found){
			found = findPath1(root.right, to, stack);
		}
		if (!found)
			stack.pop();
		return found;
	}
	
	public static void main(String[] args) {
		Integer[] array = {1,2,4,null,null,5,null,null,3,6,null,null,7,8,9};
		Node<Integer> root = Tree.createTree(array);
		System.out.println(findLen(root, 4, 9));
		System.out.println(findLen1(root, 4, 9));
	}
}


