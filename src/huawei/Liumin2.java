package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Liumin2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strs.add(cin.next());
        }
        String target = cin.next();
        for (int i = 0; i < n; i++) {
            if (!strs.get(i).contains(target)) {
                strs.remove(i);
                i--;
                n--;
            }
        }
        Collections.sort(strs);
        for (String string : strs) {
            System.out.println(string);
        }
    }
}
