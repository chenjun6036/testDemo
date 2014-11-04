package huawei;

import java.util.Scanner;

/**
 * 通过键盘输入100以内正整数的加、减运算式，请编写一个程序输出运算结果字符串。
 * 输入字符串的格式为：“操作数1 运算符 操作数2”，“操作数”与“运算符”之间以一个空格隔开。
 * <p>
 * 补充说明：
 * 1、操作数为正整数，不需要考虑计算结果溢出的情况。
 * 2、若输入算式格式错误，输出结果为“0”。
 *
 * @author chenjun
 */
public class Arithmetic {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String input = cin.nextLine();
            String[] strs = input.split(" ");
            if (strs.length != 3) {
                System.out.println(0);
                continue;
            }
            if (!"+".equals(strs[1]) && !"-".equals(strs[1])) {
                System.out.println(0);
                continue;
            }
            try {
                Integer a = Integer.valueOf(strs[0]);
                Integer b = Integer.valueOf(strs[2]);
                if (strs[1].equals("+")) {
                    System.out.println(a + b);
                } else {
                    System.out.println(a - b);
                }
            } catch (NumberFormatException nfe) {
                System.out.println(0);
                continue;
            }
        }
    }
}
