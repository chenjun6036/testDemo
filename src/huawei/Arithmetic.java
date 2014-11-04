package huawei;

import java.util.Scanner;

/**
 * ͨ����������100�����������ļӡ�������ʽ�����дһ����������������ַ�����
 * �����ַ����ĸ�ʽΪ����������1 ����� ������2���������������롰�������֮����һ���ո������
 * <p>
 * ����˵����
 * 1��������Ϊ������������Ҫ���Ǽ���������������
 * 2����������ʽ��ʽ����������Ϊ��0����
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
