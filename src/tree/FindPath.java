package tree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * ��ָoffer������25���������к�Ϊĳһֵ��·��<br/>
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ����������·���������ĸ��ڵ㿪ʼ����һֱ��Ҷ�ӽڵ��������Ľڵ��γ�һ��·����
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
