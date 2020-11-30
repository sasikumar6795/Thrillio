package com.wipro.scholarship;

public class ScholarshipMain {

	public static void main(String[] args)
	{
		MarkList markList = new MarkList(1001, 85, 65, 45);
		System.out.println(markList.Result(40));
		System.out.println(markList.Result(40, 75));
		MarkList markList1 = new MarkList(1002, 85, 92, 90);
		System.out.println(markList1.Result(40));
		System.out.println(markList1.Result(40, 75));
		MarkList markList2 = new MarkList(1003, 85, 65, 35);
		System.out.println(markList2.Result(40));
		System.out.println(markList2.Result(40, 75));
		MarkList markList3 = new MarkList(1004, 85, 65, 75);
		System.out.println(markList3.Result(40));
		System.out.println(markList3.Result(40, 75));
		MarkList markList4 = new MarkList(1005, 85, 85, 85);
		System.out.println(markList4.Result(40));
		System.out.println(markList4.Result(40, 75));
		
		
	}

}
