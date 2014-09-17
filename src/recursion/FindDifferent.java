package recursion;

import java.util.LinkedList;

/**
 * 找出1,2...n中不同的m个数的所有组合
 * @author chenjun
 *
 */
public class FindDifferent {
	void find(int n, int k, int start,LinkedList<Integer> stack) {
		if (k > n)
			return;
		if (k == 0) {
			for (Integer integer : stack) {
				System.out.print(integer);
			}
			System.out.println();
			return;
		}
		while (start + k <= n + 1) {
			stack.push(start);
			find(n,k - 1, ++start,stack);
			stack.pop();
		}
	}
	
	public static void main(String[] args) {
		FindDifferent different = new FindDifferent();
		LinkedList<Integer> stack = new LinkedList<>();
		different.find(3, 2, 1,stack);
	}
}
