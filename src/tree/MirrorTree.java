package tree;
/**
 * 剑指offer面试题19：二叉树的镜像<br/>
 * 请完成一个函数，输入一个二叉树，输出他的镜像。
 * @author chenjun
 *
 */
public class MirrorTree<T> {
	public void mirrorTree(Node<T> root){
		if(root == null)
			return;
		Node<T> temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorTree(root.left);		
		mirrorTree(root.right);
		
	}
	
	public static void main(String[] args) {
		Integer[] array = {1,2,4,null,null,5,null,null,3,6,null,null,7};
		MirrorTree<Integer> mirror = new MirrorTree<>();
		Node<Integer> root = Tree.createTree(array);
		Tree.printTreePreOrder(root);
		System.out.println();
		mirror.mirrorTree(root);
		Tree.printTreePreOrder(root);
	}
}
