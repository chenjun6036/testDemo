package array;

/**
 * ��ָoffer��������14����������˳��ʹ����λ��ż��ǰ��<br/>
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ��ż��λ������ĺ�벿�֡�
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
