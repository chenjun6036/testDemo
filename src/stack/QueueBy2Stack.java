package stack;

import java.util.LinkedList;


/**
 * ������ջʵ�ֶ���
 *
 * @author chenjun
 */
public class QueueBy2Stack<T> {
    private LinkedList<T> stack1 = new LinkedList<>();//push
    private LinkedList<T> stack2 = new LinkedList<>();//pop

    /**
     * ��ֵ
     *
     * @param t
     */
    public void appendTail(final T t) {
        stack1.push(t);
    }

    /**
     * ȡֵ
     *
     * @return
     * @throws Exception
     */
    public T deleteHead() throws Exception {
        //��stack2Ϊ�գ����stack1���������ȫ��push��stack2��
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        if (stack2.isEmpty())
            throw new Exception("Queue is empty!");
        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        QueueBy2Stack<Integer> qs = new QueueBy2Stack<>();
        qs.appendTail(1);
        qs.appendTail(2);
        qs.appendTail(3);
        qs.appendTail(4);
        System.out.println(qs.deleteHead());
        System.out.println(qs.deleteHead());
        System.out.println(qs.deleteHead());
        System.out.println(qs.deleteHead());
        System.out.println(qs.deleteHead());
    }
}
