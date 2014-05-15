package string;

public class Test {
	public static void strcpy(char[] src, char[] dst){
		for (int  i = 0; i < src.length; i++) {
			dst[i] = src[i];
		}
	}
	/**
	 * 自己实现的
	 * @param src
	 * @param des
	 * @return
	 */
	public static int strcmp(char[] src, char[] des){
		int i = 0, j = 0;
		int det = 0;
		while(i < src.length && j < des.length && (det = src[i] - des[i]) == 0){
			i++;
			j++;
		}
		if(det > 0)
			return 1;
		if(det < 0)
			return -1;
//		if(i == src.length && j == des.length)
//			return 0;
//		if(i != src.length)
//			return 1;
//		return -1;
		return src.length - des.length;
	}
	
	public static int strcmp1(char[] src, char[] des){
		int len1 = src.length;
		int len2 = des.length;
		int min = len1 > len2 ? len1 : len2;
		int k = 0;
		while(k < min){
			char c1 = src[k];
			char c2 = des[k];
			if(c1 != c2)
				return (c1 - c2);
			k++;
		}
		return (len1 - len2);
	}
	
	
	public static void main(String[] args) {
		Test t  = new Test();
		String str = "the sky is blue";
		str.indexOf("");
		str.charAt(' ');
		str.contains(str);
		System.out.println();
	}
	
	public String reverseWord(String s){
		char[] str = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
        while(i < j){
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(str);
    }
    public String reverseWords(String s) {
    	s = s.trim();
    	String[] strs = s.split(" +");
    	for(int i = 0; i < strs.length; i++){
    		strs[i] = reverseWord(strs[i]);
    	}
    	String s1 = new String();
    	for(int i = 0; i < strs.length; i++){
    		s1 += strs[i] + " ";
    	}
    	s1 = reverseWord(s1);
    	return s1.trim();
    }
    
}
