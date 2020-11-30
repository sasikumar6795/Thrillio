import java.util.*;
public class InsertionArray {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the size");
		int size =scan.nextInt();
		int[] array =  new int[50];
		System.out.println("enter the elements of array");
		for(int i=0;i<size;i++)
		{
			array[i] = scan.nextInt();
		}
		System.out.println("Enter the number to be inserted");
		int num = scan.nextInt();
		System.out.println("Enter the position to be inserted");
		int pos = scan.nextInt();
		for(int i=size-1;i>=pos-1;i--)
		{
			array[i+1]=array[i];
		}
		array[pos-1]=num;
		size++;
		for (int i = 0; i < size; i++) {
			System.out.println(array[i]);
		}
		
		

	}

}
