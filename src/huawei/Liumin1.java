package huawei;

import java.util.Scanner;

public class Liumin1 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int x = cin.nextInt();
		int y = cin.nextInt();
		if (y == 0) {
			System.out.println("001");
		}else {
			for (int i = 2; i <= y; i++) {
				x = x % 1000;
				x *= x;
			}
			StringBuffer sb = new StringBuffer();
			sb.append((x % 1000 - x % 100) / 100);
			sb.append((x % 100 - x % 10) / 10);
			sb.append(x % 10);
			System.out.println(sb);
		}	
	}
}
