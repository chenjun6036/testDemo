package recursion;

/**
 * È«ÅÅÁĞ
 *
 * @author chenjun
 */
public class AllRange {
    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void allRange(char[] chars, int start) {
        int len = chars.length;
        if (start == len - 1) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < len; i++) {
                swap(chars, i, start);
                allRange(chars, start + 1);
                swap(chars, i, start);
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = {'1', '2', '3'};
        allRange(chars, 0);
    }
}
