package array;
/**
 * 剑指offer 面试题12。<br/>
 * 输入数字n，按顺序打印出从1到最大的n位数。
 * @author chenjun
 *
 */
public class Print1ToMaxOfDigits {
	public static void print(int n){
		char[] numbers = new char[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = '0';
		}
		int k = 0;
		while(!increment(numbers)){
			printNumbers(numbers);
			k++;
			if(k%20 == 0)
				System.out.println();
		}
	}
	
	public static boolean increment(char[] numbers){
		boolean isOverflow = false;
		int takeover = 0;
		for(int i = numbers.length - 1; i >= 0; i--){
			int sum = numbers[i] - '0' + takeover;
			if(i == numbers.length - 1)
				sum++;
			if(sum == 10){
				if(i == 0){
					isOverflow = true;
					break;
				}else{
					takeover = 1;
					numbers[i] = '0';
				}
			}else{
				numbers[i] = (char) ('0' + sum);
				break;
			}
		}
		return isOverflow;
	}
	
	public static void printNumbers(char[] numbers){
		int i = 0;
		while(numbers[i] == '0' && i < numbers.length)
			i++;
		if(i == numbers.length){
			System.out.print('0');
			return;
		}
		while(i < numbers.length)
			System.out.print(numbers[i++]);
		System.out.print("  ");
	}
	
	public static void main(String[] args) {
		String a ="asd rew";
		char[] b = a.toCharArray();
	}
}
