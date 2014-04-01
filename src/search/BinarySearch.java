package search;

public class BinarySearch {
	public static <T extends Comparable<T>> int search(T[] array, int start, int end, T target){
		if(null == array || start > end)
			return -1;
		int mid = (start + end)/2;
		if(array[mid].equals(target))
			return mid;
		if(array[mid].compareTo(target) < 0)
			return search(array, mid + 1, end, target);
		else
			return search(array, start, mid - 1, target);
	}
	
	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5,6};
		int i = search(array, 0, array.length - 1, 6);
		System.out.println(i);
	}
}
