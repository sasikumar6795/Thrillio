import java.util.Scanner;

public class BinarySearch {

	
	public static void main(String[] args)
	{
		BinarySearch binarySearch = new BinarySearch();
		int arr[] = {2,5,6,8,10,40};
		int n = arr.length;
		int x =40;
		int result=binarySearch.binarySearchAlgorithm(arr,0,n-1,x);
		if(result==-1)
		{
			System.out.println("Element not present");
		}
		else
		{
			System.out.println("Element present " +result);
		}
		
		
	}

	int binarySearchAlgorithm(int[] arr, int l, int r, int x) {
		
		//return index if it is present
		if(r>=l)
		{
			int mid = l + (r-l)/2 ;
			System.out.println(mid);
			if(arr[mid]==x)
			{
				return mid;
			}
			else if (arr[mid] > x)
			{
				return binarySearchAlgorithm(arr, l, mid-1, x);
			}
			else {
				// Else the element can only be present 
	            // in right subarray 
	            return binarySearchAlgorithm(arr, mid + 1, r, x); 
			}
			
		}
		
		
		return x;
		
		
	}
	
}
