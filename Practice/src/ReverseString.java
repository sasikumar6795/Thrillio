
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "welcome to Edurekha";
		int count=0;
		String[] split = str.split(" ");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			
			count++;
		}
		//System.out.println(count);
		for (int i = 0; i < count; i++) {
			char[] charArray = split[i].toCharArray();
			for(int j=charArray.length-1;j>=0;j--)
			{
				System.out.print(charArray[j]);
			}
			System.out.print(" ");
		}
		
	}

}
