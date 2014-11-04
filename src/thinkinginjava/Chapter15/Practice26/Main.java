package thinkinginjava.Chapter15.Practice26;

public class Main {
    public static void main(String[] args) {
        Number[] nums = new Integer[10];
        try {
            nums[0] = new Integer(1);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
