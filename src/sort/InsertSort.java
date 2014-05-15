package sort;
/**
 * ≤Â»Î≈≈–Ú
 * @author chenjun
 *
 */
public class InsertSort {
	public static void sort(int[] array){
		if(array == null)
			return;
		for(int i = 1; i < array.length; i++){
			int j = 0;
			while(j < i && array[j] < array[i])
				j++;
			if(j < i){
				int tmp = array[i];
				for(int k = i; k > j; k--){
					array[k] = array[k - 1];
				}
				array[j] = tmp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {};
		sort(array);
		for (int i : array) {
			System.out.println(i);
		}
	}
}
