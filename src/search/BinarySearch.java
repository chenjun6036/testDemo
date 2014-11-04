package search;

/**
 * ���ֲ���
 *
 * @author CHENJUN
 */
public class BinarySearch {
    /**
     * ���ֲ��ң��ݹ�
     *
     * @param array  ��������
     * @param start  ��ʼλ��
     * @param end    ����λ��
     * @param target Ŀ��
     * @param <T>    ����
     * @return Ŀ������index
     */
    public static <T extends Comparable<T>> int search(T[] array, int start, int end, T target) {
        if (null == array || start > end)
            return -1;
        int mid = (start + end) / 2;
        if (array[mid].equals(target))
            return mid;
        if (array[mid].compareTo(target) < 0)
            return search(array, mid + 1, end, target);
        else
            return search(array, start, mid - 1, target);
    }

    /**
     * ���ֲ��ң��ǵݹ飬�ҳ�Ŀ���������е�һ��λ��
     *
     * @param array ��������
     * @param key   Ŀ��
     * @return Ŀ���������е�һ��index
     */
    public static int binarySearchNoRecursion(int[] array, int key) {
        if (array == null || array.length == 0)
            return -1;

        int start = 0, end = array.length, first = -1;//first������¼key��ȷ���������һ����
        while (start < end) {
            int mid = start + (end - start >> 1);//��� (end + start) / 2������end + start���
            if (array[mid] < key)
                start = mid + 1;
            else if (array[mid] > key)
                end = mid;
            else {//����ֱ�ӷ��ض��Ǽ�����ǰѰ��
                first = mid;
                end = first;
            }
        }

        return first;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5, 6};
        int i = binarySearchNoRecursion(array, 3);
        System.out.println(i);
    }
}
