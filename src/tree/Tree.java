package tree;
/**
 * 二叉树的基本操作
 * @author chenjun
 *
 * @param <T>
 */
public class Tree<T> {
	public static int i=0 ; 
	
	/**
	 * 创建二叉树
	 * @param array
	 * @return
	 */
	public static <T> Node<T> createTree(T[] array){
		if(array == null || i >= array.length  || array[i] == null){
			i++;
			return null;
		}
		Node<T> root = new Node<T>(array[i++]);
		root.left = createTree(array);
		root.right = createTree(array);
		return root;
	}
	
	/**
	 * 先序遍历打印
	 * @param root
	 */
	public static <T> void printTreePreOrder(Node<T> root){
		if(root == null)
			return;
		System.out.print(root.t + "  ");
		printTreePreOrder(root.left);
		printTreePreOrder(root.right);
	}
	
	/**
	 * 中序遍历打印
	 * @param root
	 */
	public static <T> void printTreeInOrder(Node<T> root){
		if(root == null)
			return;
		printTreeInOrder(root.left);
		System.out.print(root.t + "  ");
		printTreeInOrder(root.right);
	}
	
	
	
	/**
	 * 将二叉搜索树变为双向链表
	 * @param root
	 * @return
	 */
	public static <T> Result<T> treeToLinkedList(Node<T> root){
		Result<T> result = new Result<>();
		if(root == null)
			return null;			
		Result<T> result1 = treeToLinkedList(root.left);		
		Result<T> result2 = treeToLinkedList(root.right);
		if(result1 == null && result2 == null)
			result.lt = result.rh = root;
		else if(result1 == null){//左子树为空
			result2.lt.left = result.lt  = root;
			root.right =  result2.lt;
			result.rh = result2.rh;
		}
		else if(result2 == null){//右子树为空
			result1.rh.right = result.rh = root;
			root.left = result1.rh;
			result.lt = result1.lt;
		}else{//左右皆不为空
			result1.rh.right = result2.lt.left = root;
			result.lt = result1.lt;
			result.rh = result2.rh;
			root.left = result1.rh;
			root.right = result2.lt;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Integer[] array = {1,2,4,null,null,5,null,null,3,6,null,null,7};
		Node<Integer> root = createTree(array);
		printTreePreOrder(root);
		System.out.println();
		printTreeInOrder(root);
	}
}

class Result<T>{
	public Node<T> lt,rh;
}
