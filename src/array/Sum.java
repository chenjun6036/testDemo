package array;

/**
 * ����һ������n��Ԫ�ص���������a����a������Ԫ�صĺ͡�Ҫ���õݹ鷨��ֻ��һ�д��롣
 * @author chenjun
 *
 */
public class Sum {
	public static int sum(int[] a,int n){
		return n == 0 ? 0 : a[n - 1] + sum(a,n-1);
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(sum(a,a.length));


		
	}
}
