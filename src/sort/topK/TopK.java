package sort.topK;

import java.util.Random;

/**
 * TopK 解法
 */
public class TopK {
    private static final Integer K = 10;//前K大（小）的数，需要维护的堆的大小。

    /**
     * 调整堆
     *
     * @param heap
     * @param i
     */
    public static void maxHeapity(Double[] heap, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < K && heap[largest] < heap[left])
            largest = left;
        if (right < K && heap[largest] < heap[right])
            largest = right;
        if (i != largest) {
            exchangeItems(heap, i, largest);
            maxHeapity(heap, largest);
        }
    }

    /**
     * 建堆
     *
     * @param heap
     */
    public static void buildHeap(Double[] heap) {
        for (int i = K / 2 - 1; i >= 0; i--)
            maxHeapity(heap, i);
    }

    /**
     * 交换数组两个数
     *
     * @param A
     * @param i
     * @param j
     */
    private static void exchangeItems(Double[] A, int i, int j) {
        Double temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * 生成随机double数组
     *
     * @param range 区间
     * @return
     */
    private static Double[] randomDoubleArray(int range) {
        Double[] nums = new Double[range];
        Random rd = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextDouble() * range;
            //nums[i] = (double) i;
        }
        return nums;
    }

    public static void main(String[] args) {
        Double[] heap = randomDoubleArray(100);
        buildHeap(heap);
        for (int i = K; i < heap.length; i++) {
            if (heap[i] < heap[0]) {
                exchangeItems(heap, 0, i);
                maxHeapity(heap, 0);
            }
        }

        for (int i = 0; i < K; i++)
            System.out.print(heap[i] + "   ");
    }
}
