package sort;

public class QuickSort {
	
	public static int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		int temp;
		for (int j = p; j < r; j++) {
			if (A[j] <= x){
				i++;
				temp = A[j];
				A[j] = A[i];
				A[i] = temp;
			}
		}
		temp = A[i+1];
		A[i+1] = A[r];
		A[r] = temp;
		return i+1;
	}
	
	public static void quickSort(int[] A, int p, int r) {
		if (p < r){
		int q = partition(A, p, r);
		quickSort(A, p, q - 1);
		quickSort(A, q + 1, r);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{0,1,4,67,21,34,65,22};
		quickSort(A, 0, A.length - 1);
		for (int i : A) {
			System.out.print(i + "  ");
		}		
	}

}
