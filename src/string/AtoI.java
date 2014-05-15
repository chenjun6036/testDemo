package string;

public class AtoI {
	public static Integer transform(String str){
		Integer result = null;
		try{
			char[] str1 = str.toCharArray();
			for (char c : str1) {
				if(c < '0' || c > '9'){
					throw new Exception("Invalid number!");
				}
			}
			result = 0;
			for (int i = 0; i < str1.length; i++) {
				result += (str1[i] - '0') * (int)Math.pow(10, (str1.length - i - 1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(transform("31"));
	}
}
