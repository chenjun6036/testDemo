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
		int[] A = {122,345,2,1,3,34,567};
		topK(A,3);
		for(int i : A){
			System.out.print(i + "  ");
		}		
	}
	
	//practice
	public static void adjustHeap(int[] array, int root){
		int left = root * 2 + 1;
		int right = root * 2 + 2;
		int max = root;
		if(left < heapSize && array[left] > array[max])
			max = left;
		if(right < heapSize && array[right] > array[max])
			max = right;
		if(max != root){
			int tmp = array[root];
			array[root] = array[max];
			array[max] = tmp;
			adjustHeap(array, max);
		}
	}
	
	public static void buildHeap(int[] array){
		for(int i = array.length / 2; i >= 0; i--){
			adjustHeap(array, i);
		}
	}
	
	public static void heapSort(int[] array){
		if(array == null)
			return;
		buildHeap(array);
		while(heapSize > 0){
			int tmp = array[0];
			array[0] = array[heapSize - 1];
			array[heapSize - 1] = tmp;
			heapSize--;
			adjustHeap(array, 0);
		}
	}
	
	public static void topK(int[] array, int k){
		heapSize = k;
		buildHeap(array);
		for(int i = k; i< array.length; i++){
			if(array[i] < array[0]){
				array[0] = array[i];
				adjustHeap(array, 0);
			}
		}
	}
}