package huawei;

import java.util.Scanner;
/**
 * ͨ����������һ��Сд��ĸ(a~z)��ɵ��ַ��������дһ���ַ������˳������ַ����г��ֶ����ͬ���ַ��������״γ��ֵ��ַ����˵���
 * �����ַ�����abacacde�����˽��Ϊ��abcde����
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
