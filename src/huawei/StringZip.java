package huawei;

import java.util.Scanner;

/**
 * 通过键盘输入一串小写字母(a~z)组成的字符串。请编写一个字符串压缩程序，将字符串中连续出席的重复字母进行压缩，并输出压缩后的字符串。
 * 压缩规则：
 *1、仅压缩连续重复出现的字符。比如字符串"abcbc"由于无连续重复字符，压缩后的字符串还是"abcbc"。
 *2、压缩字段的格式为"字符重复的次数+字符"。例如：字符串"xxxyyyyyyz"压缩后就成为"3x6yz"。
 * @author chenjun
 *
 */
public class StringZip {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()) {
			String inputStr = cin.nextLine();
			StringBuffer sb = new StringBuffer();
			char current = inputStr.charAt(0);
			int count = 0;
			for(int i = 0; i < inputStr.length(); i++){
				if(inputStr.charAt(i) == current) {
					count++;
				}else{
					if(count > 1)
						sb.append(count);
					sb.append(current);
					current = inputStr.charAt(i);
					count = 1;
				}
			}
			if(count > 1)
				sb.append(count);
			sb.append(current);
			System.out.println(sb);
		}
	}
}
