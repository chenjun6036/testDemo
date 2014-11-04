package array;

/**
 * 剑指offer，面试题14：调整数组顺序使奇数位于偶数前面<br/>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得偶数位于数组的后半部分。
 *
 * @author chenjun
 */
public class ReorderArrays {
    public static void reorder(int[] array) {
        for (int i = 0, j = array.length - 1; i < j; ) {
            if (array[i] % 2 == 0 && array[j] % 2 == 1) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            } else if (array[i] % 2 == 0)
                j--;
            else
                i++;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        reorder(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
