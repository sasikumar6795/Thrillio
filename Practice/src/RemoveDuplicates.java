import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

	public static void main(String[] args)
	{
		String str = "geekss@for@geekss"; 
		String[] ar =str.split("@", 2);
		for(String a :ar )
		{
			System.out.println(a);
		}
		
		Map<String,String> gfg = new HashMap<String,String>(); 
	      
        // enter name/url pair 
        gfg.put("GFG", "geeksforgeeks.org"); 
        gfg.put("Practice", "practice.geeksforgeeks.org"); 
        gfg.put("Code", "code.geeksforgeeks.org"); 
        gfg.put("Quiz", "quiz.geeksforgeeks.org"); 
        
        
        for (int i = 0; i < gfg.size(); i++) {
				System.out.println(gfg.values());
		}

	}

}
