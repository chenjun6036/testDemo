package sort;
/**
 * Ñ¡ÔñÅÅÐò
 * @author chenjun
 *
 */
public class SelectSort {
	public static void sort(int[] array){
		if(array == null)
			return;
		int k = array.length - 1;
		while(k > 0){
			int max = 0;
			for(int i = 0; i <= k; i++){
				if(array[i] > array[max])
					max = i;
			}
			int tmp = array[k];
			array[k] = array[max];
			array[max] = tmp;
			k--;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,5,23,645,23,35,6,24};
		sort(array);
		for (int i : array) {
			System.out.println(i);
		}
	}
}
