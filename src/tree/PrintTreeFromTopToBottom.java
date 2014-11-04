package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ָoffer������23���������´�ӡ������<br/>
 * �������´�ӡ��������ÿ����㣬ͬһ��Ľ�㰴�մ�����˳���ӡ��
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
