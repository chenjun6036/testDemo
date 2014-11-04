package thinkinginjava.Chapter15.Practice27;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<? extends Number> nums = new ArrayList<Integer>();
        //nums.add(new Integer(2));
    }
}
