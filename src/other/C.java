package other;



public class C extends superC{
	
	
		public int c;
		public C(){
			c=8;
		}
		public static void addFive(){
			System.out.println("c:addfive");
		}
		public int getValue(){
			return c;
		}
		 public void finalize() {  
	        System.out.println("��ʼ�������...");  
	    }  

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		superC c = new C();
		c.addFive();
	}
	

}
