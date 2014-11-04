package array;

/**
 * ����һ������n��Ԫ�ص���������a���ҳ����е����ֵ����Сֵ
 *
 * @author chenjun
 */
public class MaxMin {
    public static int[] maxandMin(int[] a) {
        int[] result = new int[2];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i += 2) {
            int maxtmp, mintmp;
            if (i + 1 < a.length) {
                if (a[i] > a[i + 1]) {
                    maxtmp = a[i];
                    mintmp = a[i + 1];
                } else {
                    maxtmp = a[i + 1];
                    mintmp = a[i];
                }
            } else {
                maxtmp = mintmp = a[i];
            }
            if (maxtmp > max)
                max = maxtmp;
            if (mintmp < min)
                min = mintmp;
        }
        result[0] = max;
        result[1] = min;
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 1, 0, 5, 9, -6, 50};
        int[] result = maxandMin(a);
        System.out.println("���ֵ��" + result[0] + "\n���ֵ��" + result[1]);
    }
}
