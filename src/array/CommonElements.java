package array;
/**
 * 给定两个含有n个元素的有序（非降序）整型数组a和b，求出其共同元素
 * @author chenjun
 *
 */
public class CommonElements {
	
	public static void printCommonElements(int[] a, int[] b){
		int i = 0, j = 0;
		System.out.println("Common elements:");
		while(i < a.length && j < b.length){
			if(a[i] > b[j])
				j++;
			else if(a[i] == b[j]){
				System.out.print(a[i] + "\t");
				i++;
				j++;
			}else
				i++;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {0,0,2,3,4};
		int[] b = {1,3,5,7,9};
		printCommonElements(a, b);
	}
}
