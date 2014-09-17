package dp.pack;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 01背包
 * @author chenjun
 *
 */
public class ZeroOnePack {
	public static final int PACKSIZE = 20;
	public static final int COSTSIZE = 4;
	public static final int[] WEIGHT = { 5, 5, 1, 10 };
	public static final int[] VALUE = { 10, 16, 18, 21 };
	
	/**
	 * 使用二维数组，时间复杂度O(VN),空间复杂度为O(VN)
	 */
	public static void zeroOnePack2Dim() {
		int[][] f = new int[COSTSIZE + 1][PACKSIZE + 1];
		for (int i = 0; i <= PACKSIZE; i++)
			f[0][i] = 0;
		for (int i = 0; i <= COSTSIZE; i++) {
			f[i][0] = 0;
		}
		for (int i = 1; i <= COSTSIZE; i++)
			for (int j = 0; j <= PACKSIZE; j++) {
				if (WEIGHT[i - 1] <= j) {
					if (f[i - 1][j] > (f[i - 1][j - WEIGHT[i - 1]] + VALUE[i - 1])) {
						f[i][j] = f[i - 1][j];
					} else {
						f[i][j] = f[i - 1][j - WEIGHT[i - 1]] + VALUE[i - 1];
					}
				} else {
					f[i][j] = f[i - 1][j];
				}
			}
		for (int i = 0; i <= COSTSIZE; i++) {
			for (int j = 0; j <= PACKSIZE; j++) {
				System.out.print(f[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	/**
	 * 使用一维数组，不需要填满背包，时间复杂度O(VN)，不考虑路径空间复杂度为O(V)，考虑路径空间复杂度为O(VN)
	 */
	public static void zeroOnePack1Dim() {
		int f[] = new int[PACKSIZE + 1];
		int[][] path = new int[COSTSIZE][PACKSIZE + 1];
		for (int i = 0; i <= PACKSIZE; i++) {
			f[i] = 0;
		}
		for (int i = 0; i < COSTSIZE; i++)
			for (int j = 0; j <= PACKSIZE; j++)
				path[i][j] = 0;

		for (int i = 0; i < COSTSIZE; i++) {
			for (int j = PACKSIZE; j >= WEIGHT[i]; j--) {
				if (f[j - WEIGHT[i]] + VALUE[i] > f[j]) {
					f[j] = f[j - WEIGHT[i]] + VALUE[i];
					path[i][j] = 1;
				}
			}
		}
		System.out.println(f[PACKSIZE]);
		//寻路
		int i = COSTSIZE - 1;
		int j = PACKSIZE;
		while (i >= 0 && j > 0){
			if (path[i][j] == 1) {
				System.out.print(VALUE[i] + " ");
				j -= WEIGHT[i];
			}
			i--;
		}
	}

	/**
	 * 使用一维数组，正好填满背包，时间复杂度O(VN)，不考虑路径空间复杂度为O(V)，考虑路径空间复杂度为O(VN)
	 */
	public static void zeroOnePack1Dim1() {
		int f[] = new int[PACKSIZE + 1];
		int[][] path = new int[COSTSIZE][PACKSIZE + 1];
		f[0] = 0;
		for (int i = 1; i <= PACKSIZE; i++) {
			f[i] = Integer.MIN_VALUE;
		}
		for (int i = 0; i < COSTSIZE; i++)
			for (int j = 0; j <= PACKSIZE; j++)
				path[i][j] = 0;

		for (int i = 0; i < COSTSIZE; i++) {
			for (int j = PACKSIZE; j >= WEIGHT[i]; j--) {
				if (f[j - WEIGHT[i]] + VALUE[i] > f[j] && f[j - WEIGHT[i]] + VALUE[i] > 0) {
					f[j] = f[j - WEIGHT[i]] + VALUE[i];
					path[i][j] = 1;
				}
			}
		}
		System.out.println(f[PACKSIZE]);
		//寻路
		int i = COSTSIZE - 1;
		int j = PACKSIZE;
		while (i >= 0 && j > 0){
			if (path[i][j] == 1) {
				System.out.print(VALUE[i] + " ");
				j -= WEIGHT[i];
			}
			i--;
		}
	}
	
	/**
	 * 输入两个整数n和m，从数列1,2,3,4，...，n中随意取几个数使其和等于m，要求列出所有的可能组合
	 * @param n
	 * @param m
	 */
	public static void findFactor(int m, int n, LinkedList<Integer> list){
		if(m <= 0 || n <= 0) 
			return;
		if (m == n) {
			Iterator<Integer> it = list.iterator();
			while(it.hasNext()){
				System.out.print(it.next());
			}
			System.out.print(n);
			System.out.println();
		}
		list.push(n);
		findFactor(m - n, n - 1, list);
		list.pop();
		findFactor(m, n - 1, list);
	}
	
	public static void main(String[] args) {
		/*zeroOnePack1Dim1();
		System.out.println();
		zeroOnePack1Dim();*/
		findFactor(10, 6, new LinkedList<Integer>());
	}
}
