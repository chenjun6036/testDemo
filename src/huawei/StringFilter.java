package huawei;

import java.util.Scanner;
/**
 * 通过键盘输入一串小写字母(a~z)组成的字符串。请编写一个字符串过滤程序，若字符串中出现多个相同的字符，将非首次出现的字符过滤掉。
 * 比如字符串“abacacde”过滤结果为“abcde”。
 * @author chenjun
 *
 */
public class StringFilter {
	@SuppressWarnings("resource")
	public static void main(String[] args) {		
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()) {
			boolean[] flag = new boolean[26];
			for (boolean b : flag) {
				b = false;
			}
			String inputStr = cin.nextLine();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < inputStr.length(); i++){
				if(!flag[inputStr.charAt(i) - 'a']) {
					flag[inputStr.charAt(i) - 'a'] = true;
					sb.append(inputStr.charAt(i));
				}
			}
			System.out.println(sb);
		}
	}
}
