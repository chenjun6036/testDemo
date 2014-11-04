package tree;

import java.util.Arrays;

/**
 * 根据前序遍历和中序遍历重建二叉树
 *
 * @author chenjun
 */
public class RebulidBinaryTree<T> {
    public Node<T> rebuild(T[] preOrder, T[] inOrder) {
        if (preOrder.length == 0)
            return null;
        Node<T> root = new Node<>(preOrder[0]);
        int i = 0;
        while (inOrder[i] != preOrder[0])
            i++;
        if (i == 0)
            root.left = null;
        else {
            T[] preleft = Arrays.copyOfRange(preOrder, 1, i + 1);
            T[] inleft = Arrays.copyOfRange(inOrder, 0, i);
            root.left = rebuild(preleft, inleft);
        }
        if (i == preOrder.length - 1) {
            root.right = null;
        } else {
            T[] preright = Arrays.copyOfRange(preOrder, i + 1, preOrder.length);
            T[] inright = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);
            root.right = rebuild(preright, inright);
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        RebulidBinaryTree<Integer> re = new RebulidBinaryTree<>();
        Node<Integer> root = re.rebuild(preOrder, inOrder);
        Tree.printTreePreOrder(root);
        System.out.println();
        Tree.printTreeInOrder(root);
    }
}
