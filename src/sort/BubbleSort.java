package sort;
/**
 * ц╟ещеепР
 * @author chenjun
 *
 */
public class BubbleSort {
	private static <T> void swap(T[] array, int i, int j){
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	public static <T extends Comparable<T>> void sort(T[] array) throws Exception{
		if(null == array)
			throw new Exception("Array is null!");
		for(int i = array.length - 1; i >= 0; i--)
			for(int j = 0; j < i; j++){
				if(array[j].compareTo(array[j+1]) > 0)
					swap(array,j,j+1);
			}
	}
	
	public static void main(String[] args) {
		Integer[] array = {23,21,-12,54,67,-123,4};
		try {
			sort(array);
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + "  ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
