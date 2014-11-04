package dp.pack;

/**
 * ÍêÈ«±³°ü
 *
 * @author chenjun
 */
public class CompletePack {
    public static final int PACKSIZE = 20;
    public static final int COSTSIZE = 4;
    public static final int[] WEIGHT = {5, 8, 9, 10};
    public static final int[] VALUE = {10, 16, 18, 21};

    public static void completePack() {
        int[] f = new int[PACKSIZE + 1];
        for (int i = 0; i <= PACKSIZE; i++) {
            f[i] = 0;
        }

        for (int i = 0; i < COSTSIZE; i++) {
            for (int j = WEIGHT[i]; j <= PACKSIZE; j++) {
                if ((f[j - WEIGHT[i]] + VALUE[i]) > f[j]) {
                    f[j] = f[j - WEIGHT[i]] + VALUE[i];
                }
            }
            for (int j = 0; j <= PACKSIZE; j++) {
                System.out.print(f[j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        completePack();
    }
}
