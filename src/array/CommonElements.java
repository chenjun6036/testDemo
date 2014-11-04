package array;

/**
 * ������������n��Ԫ�ص����򣨷ǽ�����������a��b������佻�������Ԫ��
 *
 * @author chenjun
 */
public class CommonElements {
    /**
     * ��ӡ����A������B����Ԫ�أ���{x�Ox��A,��x��B}
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
     * ��ӡ����A���У�������B��û�е�������{x�Ox��A,��x?B}
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
