package huawei;

import java.util.Scanner;

/**
 * ͨ����������һ��Сд��ĸ(a~z)��ɵ��ַ��������дһ���ַ���ѹ�����򣬽��ַ�����������ϯ���ظ���ĸ����ѹ���������ѹ������ַ�����
 * ѹ������
 *1����ѹ�������ظ����ֵ��ַ��������ַ���"abcbc"�����������ظ��ַ���ѹ������ַ�������"abcbc"��
 *2��ѹ���ֶεĸ�ʽΪ"�ַ��ظ��Ĵ���+�ַ�"�����磺�ַ���"xxxyyyyyyz"ѹ����ͳ�Ϊ"3x6yz"��
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
