package huawei;

import java.util.Scanner;

/**
 * 描述: 1、输入一个正整数，并编码为字符串进行输出。
 * 编码规则为：数字0-9分别编码为字符a-j
 * 2、输入肯定是正整数，不用做错误较验
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
