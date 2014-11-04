package string;

/**
 * 回文字符串
 *
 * @author chenjun
 */
public class Sym {
    /**
     * 朴素解法
     *
     * @param str
     */
    static void maxSubSym(String str) {
        if (str == null)
            return;
        int id = 0;
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            // 奇数
            int n = 1;
            while (i + n < str.length() && i - n >= 0
                    && str.charAt(i + n) == str.charAt(i - n)) {
                n++;
            }
            int oddlength = 2 * (n - 1) + 1;

            // 偶数
            int n1 = 0;
            while (i - n1 >= 0 && i + n1 + 1 < str.length()
                    && str.charAt(i - n1) == str.charAt(i + n1 + 1)) {
                n1++;
            }
            int evenlength = 2 * n1;

            if (length < oddlength) {
                length = oddlength;
                id = i;
            }
            if (length < evenlength) {
                length = evenlength;
                id = i;
            }
        }
        System.out.println(length);
        if ((length & 0x01) == 0) {
            for (int i = id - length / 2 + 1; i <= id + length / 2; i++) {
                System.out.print(str.charAt(i));
            }
        } else {
            for (int i = id - length / 2; i <= id + length / 2; i++) {
                System.out.print(str.charAt(i));
            }
        }
    }

    /**
     * manacher算法
     *
     * @param str
     */
    static void MaxSubSym_manacher(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            sb.append('#');
            sb.append(str.charAt(i));
        }

        int[] p = new int[sb.length()];
        for (int i = 0; i < p.length; i++) {
            p[i] = 1;
        }

        int id = 0;
        int maxLength = 0;
        for (int i = 1; i < sb.length(); i++) {
            p[i] = Math.min(p[2 * id - maxLength], maxLength > i ? (maxLength - i) : 1);
            while ((i + p[i]) < sb.length() && (i - p[i]) > 0 && sb.charAt(i + p[i]) == sb.charAt(i - p[i])) {
                p[i]++;
            }
            if (p[i] + i > maxLength) {
                maxLength = p[i] + i;
                id = i;
            }
        }

        int max = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > max)
                max = p[i];
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        MaxSubSym_manacher("sfsfsflevelsdfgssddddss");
    }
}
