package sort;

public class Test {
	public static <T> void swap(T[] array, int i, int j){
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
	
	public static <T extends Comparable<T>> void quiksort(T[] array, int start, int end) throws Exception{
		if(array == null)
			throw new Exception("Array is null!");
		if(start < end){
			int index = partition(array, start, end);
			quiksort(array, start, index - 1);
			quiksort(array, index + 1, end);
		}
	}
	private static int heapsize;
	public static <T extends Comparable<T>> void maxHeapity(T[] array, int root){
		int left = root * 2 + 1, right = root * 2 + 2;
		int max = root;
		if(left < heapsize && array[max].compareTo(array[left]) < 0)
			max = left;
		if(right < heapsize && array[max].compareTo(array[right]) < 0)
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
		buildHeap(array);
		while(heapsize > 0){
			swap(array,0,--heapsize);
			maxHeapity(array, 0);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Integer[] array = {1,2,7,0,58,47,-6,8};
		heapsize = array.length;
		heapSort(array);
		for (Integer integer : array) {
			System.out.print(integer+"  ");
		}
	}
}
