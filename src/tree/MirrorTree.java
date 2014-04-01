package tree;
/**
 * ��ָoffer������19���������ľ���<br/>
 * �����һ������������һ����������������ľ���
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
