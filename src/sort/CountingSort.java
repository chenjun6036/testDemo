package sort;

/**
 * ¼ÆÊıÅÅĞò
 * @author chenjun
 *
 */
public class CountingSort {
	public static final int K = 6; 
	public static int[] sort(int[] array) {
		int[] count = new int[K];
		for (int i = 0; i < K; i++) {
			count[i] = 0;
		}
		
		for (int i = 0; i < array.length; i++)
			count[array[i]]++;
		
		for(int i = 1; i < K; i++)
			count[i] = count[i] + count[i - 1];
		
		int[] result = new int[array.length];
		for(int i = array.length - 1; i >= 0; i--) {
			result[count[array[i]] - 1] = array[i];
			count[array[i]]--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {2,5,3,0,2,3,0,3};
		a = sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
