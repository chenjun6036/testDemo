package tree;

import java.util.Arrays;
/**
 * 剑指offer面试题24：二叉搜索树的后序遍历序列<br/>
 * 题目：输入一个整数数组，判断数组是不是某二叉搜索树的后续遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * @author chenjun
 *
 * @param <T>
 */
public class VerifySequenceOfBST<T extends Comparable<T>> {
	public boolean verify(T[] array){
		if(array == null)
			return false;
		if(array.length == 0)
			return true;
		int i = 0;
		while(i < array.length - 1 && array[i].compareTo(array[array.length - 1]) < 0 )
			i++;
		T[] left = Arrays.copyOfRange(array, 0, i);
		T[] right = Arrays.copyOfRange(array, i, array.length - 1);
		return verify(left) && verify(right);
	}
	
	public static void main(String[] args) {
		VerifySequenceOfBST<Integer> v = new VerifySequenceOfBST<>();
		Integer array[] = {5,7,6,9,11,10,8};
		System.out.println(v.verify(array));
	}
}
