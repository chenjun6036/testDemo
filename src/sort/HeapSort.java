package sort;

public class HeapSort{
	private static int heapSize;
	private static int[] A;
	
	public static void maxHeapity(int[] A, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = i;
		if (left <= heapSize - 1 && A[left] > A[max]){
			max = left;
		}
		if (right <= heapSize - 1 && A[right] > A[max]){
			max = right;
		}
		if (max !=i){
			int temp = A[i];
			A[i] = A[max];
			A[max] = temp;
			maxHeapity(A, max);
		}		
	}
	
	public static void buildHeap(int[] A) {
		for (int i = A.length / 2 - 1; i >= 0; i--){
			maxHeapity(A, i);
		}
	}
	
	public static void heapSort(int[] A){
		buildHeap(A);
		int temp;
		for (int i = A.length - 1; i > 0; i--){
			temp = A[0];
			A[0] = A[heapSize - 1];
			A[heapSize - 1] = temp;
			heapSize--;
			maxHeapity(A, 0);
		}
	}
	
	public static void main(String[] args) {
		A = new int[]{2,1,3};
		heapSize = A.length;
		heapSort(A);
		for(int i : A){
			System.out.print(i + "  ");
		}		
	}
}