package bigData;

public class testBigData {
    public static void add(int[] a, int[] b) {
        for (int i = 0; i < a.length - 1; i++) {
            int ai = a[i];
            int bi = b[i];
            a[i] = (ai + bi) % 10;
            a[i + 1] += (ai + bi) / 10;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1};//����
        int[] b = new int[100];//���
        int[] c = new int[100];//�м�
        int[] d = new int[100];//�м�
        for (int i = 0; i < c.length; i++) {
            d[i] = c[i];
        }
        add(c, d);
        for (int i = 0; i < c.length; i++) {

            System.out.print(c[i]);
        }
    }

}
