package string;

public class TestByte {
    public static void main(String[] args) throws Exception {
        String str = "我a爱中华abc我爱传智def";

        int num = trimGBK(str.getBytes("GBK"), 5);
        System.out.println(str.substring(0, num));
        int a = 40;
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        i1 = i2 + i3;
        Integer b = new Integer(40);
        Integer c = new Integer(40);
        System.out.println(i1 == i2);
        int m = 0;
        m = m++;
        System.out.println(m);

    }

    public static int trimGBK(byte[] buf, int n) {
        int num = 0;
        boolean bChineseFirstHalf = false;
        for (int i = 0; i < n; i++) {
            if (buf[i] < 0 && !bChineseFirstHalf) {
                bChineseFirstHalf = true;
            } else {
                num++;
                bChineseFirstHalf = false;
            }
        }
        return num;
    }
}
