package com.wipro.scholarship;

public class MarkList
{
	private int regNo;
	private int s1;
	private int s2;
	private int s3;
	
	public MarkList(int regNo, int s1, int s2, int s3)
	{
		super();
		this.regNo = regNo;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}

	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public int getS1() {
		return s1;
	}

	public void setS1(int s1) {
		this.s1 = s1;
	}

	public int getS2() {
		return s2;
	}

	public void setS2(int s2) {
		this.s2 = s2;
	}

	public int getS3() {
		return s3;
	}

	public void setS3(int s3) {
		this.s3 = s3;
	}
	
	public String Result(int min)
	{
		if(getS1()>=min&&getS2()>=min&&getS3()>=min)
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	
	public String Result(int min, int merit)
	{
		if((getS1()+getS2()+getS3())/3>=merit)
		{
			return "Eligible for Scholarship";
		}
		else
		{
			return "Not Eligible for Scholarship";
		}
	}
	
	
	
	
}
