package tree;

public class Tree<T> {
	public static int i=0 ; 
	public static int maxlen = 0;
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
	
	public static <T> void printTree(Node<T> root){
		if(root == null)
			return;
		System.out.println(root.t);
		printTree(root.left);
		printTree(root.right);
	}
	
	//树中的最长距离
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
	
	//将二叉搜索树变为双向链表
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
		printTree(root);
		Result<Integer> result = treeToLinkedList(root);
		Node<Integer> p = result.lt;
		while(p != null){
			System.out.print(p.t);
			p = p.right;
		}
	}
}

class Result<T>{
	public Node<T> lt,rh;
}
