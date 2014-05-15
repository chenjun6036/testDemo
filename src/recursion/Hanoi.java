package recursion;
/**
 * ººÅµËşÎÊÌâ
 * @author chenjun
 *
 */
public class Hanoi {
	public static void hanoi(int num, int src, int dst, int tmp){
		if(num == 1){
			System.out.println(src + " to " + dst);
		}else{
			hanoi(num - 1, src, tmp, dst);
			System.out.println(src + " to " + dst);
			hanoi(num - 1,tmp, dst,src);
		}
	}
	static void swap(int[] array ,int i, int j){
	    int tmp = array[i];
	    array[i] = array[j];
	    array[j] = tmp;
	}
	static void  sort(int[] array){
	    int len = array.length;
	    int p=-1,q=len;
	    for(int i = 0;i<q;i++){
	        if(array[i] == 0){
	            p++;
	            swap(array,p,i);
	        }
	        if(array[i]==2){
	            q--;	            
	            swap(array,q,i);
	            i--;
	        }
	    }
	}
	
	static void change(char[] str){
	    int[] a = new int[257];
	    for(int i = 0;i<(int)'A';i++){
	        a[i] = 0;
	    }
	    for(int i = (int)'A'; i <= (int)'Z';i++){
	        a[i] = 32;
	    }
	    for(int i = ((int)'Z'+1);i<257;i++){
	        a[i] = 0;
	    }
	    
	    for(int i =0;i<str.length;i++){
	        str[i] += a[(int)str[i]];
	    }
	    
	    for (char i : str) {
			System.out.print(i);
		}
	    
	}
	public static void main(String[] args) {
//		String str = "AsdsaWeDS,sdaA";
//		char[] a = str.toCharArray();
//		change(a);
		
		int[] a = {0,2,1,2,0,0,0,1,2};
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
