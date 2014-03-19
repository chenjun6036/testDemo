package dp;

public class MaxSubArray {
	public static int max(int i, int j){
		return i > j ? i : j;
	}
	public static int maxSum(int[] a){
		int n = a.length;
		int all=0,start = a[n - 1];
		for(int i = n -2; i >= 0; i--){
			start  = max(a[i], start + a[i]);
			all = max(all, start);
			System.out.println(start);
			System.out.println(all);
		}
		return all;
	}
	
	//�����ҵ�ʼĩ�±�
	public static int maxSum1(int[] a){
		int n = a.length;
		int flag = 0, max = 0;
		//�ж��Ƿ�û������
		for(int i = 0; i < n; i++){
			if(a[i] > 0)
				flag = 1;
			if(a[i] > a[max]){
				max = i;
			}
		}
		int starta = n - 1,startb = n - 1;
		int alla = n -1, allb = n - 1;
		int all = 0, start = a[n - 1];
		if(flag == 0){//û������
			all=  a[max];
			alla = allb = max;	
			System.out.println("��������飺" + all);
			System.out.println("��ʼ�±�" + alla);
			System.out.println("��ֹ�±�" + allb);
		}else{//������
			for(int i = n - 2; i >= 0; i--){
				starta = i;
				if(start < 0){
					start = 0;
					startb = i;
				}
				start += a[i];
				if(start > all){
					all = start;
					alla = starta;
					allb = startb;
				}
				
			}
			System.out.println("��������飺" + all);
			System.out.println("��ʼ�±�" + alla);
			System.out.println("��ֹ�±�" + allb);
		}
		return all;
	}
	public static void main(String[] args) {
		int[] a = {-12, -8, -5, 66, -21, 0 ,35,-44,-7};
		maxSum1(a);
	}
}
