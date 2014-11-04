package dp;

/**
 * LIS，最长递增子序列，编程之美2.16
 *
 * @author chenjun
 */
public class LongestIncreaseSubArray {
    public static int max(int[] a) {
        int max = a[0];
        for (int i : a) {
            if (i > max)
                max = i;
        }
        return max;
    }

    public static int LISsimple(int[] a) {
        int n = a.length;
        int[] LIS = new int[n];
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && LIS[j] + 1 > LIS[i]) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }
        return max(LIS);
    }

    public static int LIS(int[] a) {
        int n = a.length;
        int[] LIS = new int[n];
        int[] maxV = new int[n + 1];
        int nmaxLIS = 1;
        LIS[0] = 1;
        for (int i = 1; i < n; i++) {
            LIS[i] = 1;
            int j;
            for (j = nmaxLIS; j > 0; j--) {
                if (a[i] > maxV[j]) {
                    LIS[i] = j + 1;
                    break;
                }
            }
            if (LIS[i] > nmaxLIS) {
                nmaxLIS = LIS[i];
            } else if (maxV[j + 1] > a[i] && maxV[j] < a[i]) {
                maxV[j + 1] = a[i];
            }
        }
        return nmaxLIS;
    }

    /**
     * 待练习
     *
     * @param array
     * @return
     */
    public static int LISPractice(int[] array) {
        int n = array.length;
        int[] LIS = new int[n];
        int[] maxV = new int[n + 1];
        int max = 1;

        for (int i = 1; i < n; i++) {
            LIS[i] = 1;
            int j = max;
            while (j > 0) {
                if (array[i] > maxV[j]) {
                    LIS[i] = j + 1;
                    break;
                }
                j--;
            }

            if (max < LIS[i]) {
                max = LIS[i];
                maxV[max] = array[i];
            } else if (array[i] > maxV[j] && array[i] < maxV[LIS[i]]) {
                maxV[LIS[i]] = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, -1, 2, -3, 4, -5, 6, -7, 10};
        System.out.println(LISPractice(a));
    }
}
