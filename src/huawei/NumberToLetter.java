package huawei;

import java.util.Scanner;

/**
 * ����: 1������һ����������������Ϊ�ַ������������
 * �������Ϊ������0-9�ֱ����Ϊ�ַ�a-j
 * 2������϶������������������������
 * @author chenjun
 *
 */
public class NumberToLetter {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()) {
			String input = cin.nextLine();
			for(int i = 0; i < input.length(); i++){
				char r = (char) ('a' + input.charAt(i) - '0');
				System.out.print(r);
			}
			System.out.println();
		}
	}
}
