
public class Test {
	
	String ctag;
	
	Test(String ctag)
	{
		this.ctag = ctag;
	}
	
	public String validation()
	{
		if(this.ctag.length()<=6)
		{
			return this.ctag;
		}
		else
		{
			
			return "not a valid value";
		}
	}
	@Override
	public String toString() {
		return "Test [ctag=" + ctag + "]";
	}

	public static void main(String[] args)
	{
		
		Test test = new Test("sasi");
		System.out.println(test.validation());
		
		
		

	}

}
