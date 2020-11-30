

public class DataPassed {
	
	static final int x;
	
	static 
	{
		x =23;	
	}
	public static void main(String[] args) {
		
		int id=1000;
		updateId(id);
		System.out.println(id);
		
		
		
		
		
	}
	
	
	
	public  static void updateId(int id)
	{
		 id=1001;
	}
	
	
}
