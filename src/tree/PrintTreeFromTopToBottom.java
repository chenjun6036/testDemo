package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer面试题23：从上往下打印二叉树<br/>
 * 从上往下打印二叉树的每个结点，同一层的结点按照从左到右顺序打印。
 *
 * @author chenjun
 */
public class PrintTreeFromTopToBottom<T> {
    public void print(Node<T> root) {
        if (null == root)
            return;
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node<T> node = nodes.poll();
            if (node.left != null)
                nodes.add(node.left);
            if (node.right != null)
                nodes.add(node.right);
            System.out.print(node + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7};
        Node<Integer> root = Tree.createTree(array);
        PrintTreeFromTopToBottom<Integer> pt = new PrintTreeFromTopToBottom<>();
        pt.print(root);
    }
}
