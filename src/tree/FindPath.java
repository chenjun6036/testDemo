package tree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 剑指offer面试题25：二叉树中和为某一值的路径<br/>
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的路径。从树的根节点开始往下一直到叶子节点所经过的节点形成一条路径。
 * @author chenjun
 *
 */
public class FindPath {	
	public void find(Node<Integer> root,int pathNum,LinkedList<Node<Integer>> pathstack, int currentNum){
		if(root == null)
			return;
		currentNum += root.t;
		pathstack.push(root);
		if(pathNum < currentNum){
			pathstack.pop();
			return;
		}			
		boolean isLeaf = root.left == null && root.right == null;
		if(currentNum == pathNum && isLeaf){
			Iterator<Node<Integer>> it = pathstack.iterator();
			while(it.hasNext())
				System.out.println(it.next().t);
		}
		if(root.left != null){
			find(root.left, pathNum, pathstack, currentNum);
		}
		if(root.right != null){
			find(root.right, pathNum, pathstack, currentNum);
		}
		pathstack.pop();
	}
	public static void main(String[] args) {
		LinkedList<Node<Integer>> pathstack = new LinkedList<>();
		Integer[] array = {1,2,4,null,null,5,null,null,3,6,null,null,7};
		Node<Integer> root = Tree.createTree(array);
		FindPath fp = new FindPath();
		fp.find(root, 8, pathstack, 0);
	}
}
