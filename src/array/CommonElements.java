package array;

/**
 * 给定两个含有n个元素的有序（非降序）整型数组a和b，求出其交集（差集）元素
 *
 * @author chenjun
 */
public class CommonElements {
    /**
     * 打印数组A和数组B交集元素，即{x∣x∈A,且x∈B}
     *
     * @param A
     * @param B
     */
    public static void printCommonElements(int[] A, int[] B) {
        int i = 0, j = 0;
        System.out.println("Common elements:");
        while (i < A.length && j < B.length) {
            if (A[i] > B[j])
                j++;
            else if (A[i] == B[j]) {
                System.out.print(A[i] + "\t");
                i++;
                j++;
            } else
                i++;
        }
    }

    /**
     * 打印数组A中有，且数组B中没有的数，即{x∣x∈A,且x?B}
     *
     * @param A
     * @param B
     */
    public static void printUnCommonElements(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                i++;
                j++;
            } else if (A[i] < B[j]) {
                System.out.println(A[i++]);
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 2, 3, 4};
        int[] b = {1, 3, 5, 7, 9};
        printUnCommonElements(a, b);
    }
}
