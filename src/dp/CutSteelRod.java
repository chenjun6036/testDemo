package dp;

public class CutSteelRod {
	public static void main(String[] args) {
		int[] p = {0,1,5,8,9,10,17,17,20,24,30};
		int n = p.length;
		int[] r = new int[n];
		int[] s = new int[n];
		r[0] = 0;
		for(int i = 1; i < n; i++){
			int q = Integer.MIN_VALUE;
			for(int j = 1; j <= i; j++){
				if(q < p[j] + r[i-j]){
					q = p[j] + r[i-j];
					s[i] = j;
				}
				r[i] = q;
			}
		}
		for(int i = 0; i < n; i++){
			System.out.print( i + "   ");
		}
		System.out.println();
		for(int i = 0; i < n; i++){
			System.out.print( r[i] + "   ");
		}
		System.out.println();
		for(int i = 0; i < n; i++){
			System.out.print( s[i] + "   ");
		}
	}
}
