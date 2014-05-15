package tree;

import java.util.Arrays;
/**
 * ��ָoffer������24�������������ĺ����������<br/>
 * ��Ŀ������һ���������飬�ж������ǲ���ĳ�����������ĺ������������������򷵻�true�����򷵻�false���������������������������ֶ�������ͬ��
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
