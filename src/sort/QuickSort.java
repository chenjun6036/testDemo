package sort;
/**
 * ¿ìËÙÅÅĞò
 * @author chenjun
 *
 */
public class QuickSort {
	
	private static <T> void swap(T[] array, int i, int j){
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	public static <T extends Comparable<T>> int partition(T[] array, int start, int end){		
		int larger = start;
		int p = start;
		for(p = start; p <= end; p++){
			if(array[p].compareTo(array[end]) < 0){
				swap(array,p,larger);
				larger++;
			}
		}
		swap(array, end ,larger);		
		return larger;
	}
	
	public static <T extends Comparable<T>> void quikSort(T[] array, int start, int end) throws Exception{
		if(array == null)
			throw new Exception("Array is null!");
		if(start < end){
			int index = partition(array, start, end);
			quikSort(array, start, index - 1);
			quikSort(array, index + 1, end);
		}
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Integer[] A ={0,1,4,67,21,34,65,22};
		quikSort(A, 0, A.length - 1);
		for (int i : A) {
			System.out.print(i + "  ");
		}		
	}

}
