package sort;

import java.util.Arrays;

/**
 * πÈ≤¢≈≈–Ú
 *
 * @author chenjun
 */
public class MergeSort<T extends Comparable<T>> {
    private static <T extends Comparable<T>> void merge(T[] array, int p, int q, int r) {
        T[] array1 = Arrays.copyOfRange(array, p, q + 1);
        T[] array2 = Arrays.copyOfRange(array, q + 1, r + 1);
        int i = 0, j = 0, k = p;
        while (i < array1.length && j < array2.length) {
            if (array1[i].compareTo(array2[j]) < 0)
                array[k++] = array1[i++];
            else
                array[k++] = array2[j++];
        }
        while (i < array1.length)
            array[k++] = array1[i++];
        while (j < array2.length)
            array[k++] = array2[j++];
    }

    public static <T extends Comparable<T>> void sort(T[] array, int start, int end) {
        if (end > start) {
            int mid = (start + end) / 2;
            sort(array, start, mid);
            sort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] array = {23, 21, -12, 54, 67, -123, 4};
        mergeSort(array, 0, array.length - 1);
        for (Integer integer : array) {
            System.out.print(integer + "   ");
        }
    }

    //practice
    public static void merge(int[] array, int p, int q, int r) {
        int[] a = new int[q - p + 2];
        int[] b = new int[r - q + 1];
        for (int i = p, m = 0; i <= q; i++, m++) {
            a[m] = array[i];
        }
        a[q - p + 1] = Integer.MAX_VALUE;
        for (int i = q + 1, m = 0; i <= r; i++, m++) {
            b[m] = array[i];
        }
        b[r - q] = Integer.MAX_VALUE;
        int i = 0, j = 0, k = p;
        while (k <= r) {
            if (a[i] < b[j])
                array[k++] = a[i++];
            else
                array[k++] = b[j++];
        }
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }
}
