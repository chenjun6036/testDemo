package tree;

public class Node<T> {
    public T t;
    public Node<T> left, right;
    public int leftLen, rightLen;

    Node(T t) {
        this.t = t;
        this.left = null;
        this.right = null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this.t.equals(((Node<T>) obj).t))
            return true;
        return false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return t.toString();
    }
}
