package dp;

import java.util.ArrayList;
import java.util.List;

public class LCS {

	public static List<Character> resultList = new ArrayList<Character>();
	/**
	 * 最长公共子序列，计算最优值 
	 * @param x
	 *            字符系列数组
	 * @param y
	 *            字符系列数组
	 * @param c
	 *            存储x和y最长公共子系列长度数组
	 * @param b
	 *            记录c中元素对应子问题的解的数组
	 */
	public static void lcsLength(char x[], char y[], int[][] c, int[][] b) {
		int m = x.length ;
		int n = y.length ;
		resultList.clear();

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 1;
				} else if (c[i - 1][j] > c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					b[i][j] = 2;
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = 3;
				}
			}
		}
	}

	/**
	 * 构造最长公共子系列，递归 
	 * @param i
	 *            数组下标
	 * @param j
	 *            数组下标
	 * @param x
	 *            字符系列数组
	 * @param b
	 *            记录c中元素对应子问题的解的数组
	 */
	public static void lcs(int i, int j, char x[], int[][] b) {
		if (i == 0 || j == 0) {
			return;
		}
		if (b[i][j] == 1) {
			lcs(i - 1, j - 1, x, b);
			resultList.add(x[i - 1]);
		} else if (b[i][j] == 2) {
			lcs(i - 1, j, x, b);
		} else {
			lcs(i, j - 1, x, b);
		}
	}
	
	/**
	 * 最长公共子序列，不需要b[][],空间复杂度为O(m*n)
	 * @param A
	 * @param B
	 */
	public static void LCS(char[] A, char[] B){
		if(A == null || B == null) 
			return ;
		
		int[][] c = new int[A.length  + 1][B.length + 1];
		
		for (int i = A.length - 1; i >=0; i--)
			for (int j = B.length - 1; j >= 0; j--) {
				if (A[i] == B[j]) 
					c[i][j] += c[i + 1][j + 1] + 1;
				else 
					c[i][j] = Math.max(c[i + 1][j], c[i][j + 1]);
			}
		
		for (int i = 0, j = 0; i < A.length && j < B.length;) {
			if (A[i] == B[j]) {
				System.out.println(A[i]);
				i++;
				j++;
			} else if (c[i][j + 1] >= c[i + 1][j]){
				j++;
			} else 
				i++;
		}		
	}
	
	/**
	 * 最长公共子序列，不需要b[][],空间复杂度为O(m) 或 O(n)
	 * @param A
	 * @param B
	 * @return
	 */
	public static int LCSlength(char[] A, char[] B) {
		if(A == null || B == null) 
			return 0;
		int[] c = new int[B.length + 1];
		//使用temp存储c[i + 1][j + 1]
		for (int i = A.length - 1; i >= 0; i--){
			int temp = 0;
			for (int j = B.length - 1; j >= 0; j--) {
				if (A[i] == B[j]){
					int temp1 = c[j];
					c[j] = temp + 1;
					temp = temp1;
				} else if(c[j + 1] > c[j]) {
					temp = c[j];
					c[j] = c[j + 1];
				} else {
					temp = c[j];
				}				
			}
			for (int m : c) {
				System.out.print(m + " ");
			}
			System.out.println();
		}
		return c[0];
	}
	
	
	/**
	 * 最长公共子串
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int getLCSubstring(char[] str1, char[] str2) {    
        int max = 0;// 保存最长子串长度
        int[] temp = new int[str1.length + 1];  
 
        for (int i = str2.length - 1; i >= 0; i--) {  
            for (int j = 1; j < str1.length; j++) {  
                if (str2[i] == str1[j]) { 
                	temp[j] = temp[j + 1] + 1;  
                } else {  
                    temp[j] = 0;  
                } 
                if (temp[j] > max) {  
                    max = temp[j];                     
                }
            } 
            for (int m : temp) {
				System.out.print(m + " ");
			}
            System.out.println();
        }          
        return max;
    }  
	
	
	/**
	 * 最长公共子串
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int getLCSubtring1(char[] str1, char[] str2) {  
        int len1, len2;  
        len1 = str1.length;  
        len2 = str2.length;  
        int maxLen = len1 > len2 ? len1 : len2;  
  
        int max = 0;// 保存最长子串长度
        int[] temp = new int[maxLen];  
 
        for (int i = 0; i < len2; i++) {  
            for (int j = len1 - 1; j >= 0; j--) {  
                if (str2[i] == str1[j]) {  
                    if ((i == 0) || (j == 0))  
                        temp[j] = 1;  
                    else  
                        temp[j] = temp[j - 1] + 1;  
                } else {  
                    temp[j] = 0;  
                } 
                if (temp[j] > max) {  
                    max = temp[j];                     
                }
            } 
            for (int m : temp) {
				System.out.print(m + " ");
			}
            System.out.println();
        }          
        return max;
    }  
	
	

	public static void main(String arg[]) {
		String str1 = new String("ABACDB");  
        String str2 = new String("BADBCBAC");  
        System.out.println(getLCSubstring(str2.toCharArray(), str1.toCharArray()));
	}
}
