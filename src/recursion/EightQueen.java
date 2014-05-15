package recursion;
/**
 * ∞Àª ∫ÛŒ Ã‚
 * @author chenjun
 *
 */
public class EightQueen {
	private static final int length = 8;
	static int  num = 0;
	static int[]  queenList = new int[length];
	public static boolean check(int row ,int col){
		for(int k = 0; k < queenList.length; k++){
			if(queenList[k] != -1 && ((k + queenList[k] == row + col) || (k - queenList[k] == row - col) || k == row || queenList[k] == col))
				return false;
		}
		return true;
	}
	public static void queen(int col){
		if(col == length){
			num++;
			return;
		}
		for(int row = 0; row < length; row++){
			if(check(row , col)){
				queenList[row] = col;			
				queen(col+1);
				queenList[row] = -1;
			}
		}
	}	
	public static void main(String[] args) {
		for (int i = 0; i < queenList.length; i++) {
			queenList[i] = -1;
		}
		queen(0);
		System.out.println(num);
	}
}
