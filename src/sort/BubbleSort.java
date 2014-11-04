package sort;

/**
 * 冒泡排序
 *
 * @author chenjun
 */
public class BubbleSort {

    /**
     * 数组两个数交换位置
     *
     * @param array
     * @param i
     * @param j
     * @param <T>
     */
    private static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 冒泡排序
     *
     * @param array
     * @param <T>
     * @throws Exception
     */
    public static <T extends Comparable<T>> void sort(T[] array) throws Exception {
        if (null == array)
            throw new Exception("Array is null!");
        for (int i = array.length - 1; i >= 0; i--)
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0)
                    swap(array, j, j + 1);
            }
    }

    public static void main(String[] args) {
        int[] array = {23, 21, -12, 54, 67, -123, 4};
        try {
            sort(array);
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "  ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //practice
    public static void sort(int[] array) {
        if (array == null)
            return;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
