package sort;
/**
 * ∂—≈≈–Ú
 * @author chenjun
 *
 */
public class HeapSort{
	private static int heapSize;
	private static <T> void swap(T[] array, int i, int j){
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	public static <T extends Comparable<T>> void maxHeapity(T[] array, int root){
		int left = root * 2 + 1, right = root * 2 + 2;
		int max = root;
		if(left < heapSize && array[max].compareTo(array[left]) < 0)
			max = left;
		if(right < heapSize && array[max].compareTo(array[right]) < 0)
			max = right;
		if(max != root){
			swap(array,max,root);
			maxHeapity(array, max);
		}			
	}
	
	public static <T extends Comparable<T>> void buildHeap(T[] array){
		for(int i = array.length/2; i >= 0; i--){
			maxHeapity(array, i);
		}
	}
	
	public static <T extends Comparable<T>> void heapSort(T[] array){
		if(array == null)
			return;
		buildHeap(array);
		while(heapSize > 0){
			swap(array,0,--heapSize);
			maxHeapity(array, 0);
		}
	}
	
	public static void main(String[] args) {
		Integer[] A = {2,1,3};
		heapSize = A.length;
		heapSort(A);
		for(int i : A){
			System.out.print(i + "  ");
		}		
	}
}