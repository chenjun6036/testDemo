package search;

/**
 * 二分查找
 *
 * @author CHENJUN
 */
public class BinarySearch {
    /**
     * 二分查找，递归
     *
     * @param array  查找数组
     * @param start  开始位置
     * @param end    结束位置
     * @param target 目标
     * @param <T>    类型
     * @return 目标所在index
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
     * 二分查找，非递归，找出目标在数组中第一个位置
     *
     * @param array 查找数组
     * @param key   目标
     * @return 目标在数组中第一个index
     */
    public static int binarySearchNoRecursion(int[] array, int key) {
        if (array == null || array.length == 0)
            return -1;

        int start = 0, end = array.length, first = -1;//first用来记录key，确保是数组第一个。
        while (start < end) {
            int mid = start + (end - start >> 1);//替代 (end + start) / 2；避免end + start溢出
            if (array[mid] < key)
                start = mid + 1;
            else if (array[mid] > key)
                end = mid;
            else {//不是直接返回而是继续向前寻找
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
