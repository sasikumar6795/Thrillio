package com.sasi.collections;

import java.util.function.Consumer;

public class Filter implements Consumer {
	static void filter(Integer i )
	{
		if(i==1)
		{
			System.out.println(i);
		}
	}
	
	@Override
	public void accept(Object i)
	{
		if((int)i==1)
		{
			System.out.println(i);
		}
	}
	
	static void add(Integer i )
	{
		System.out.println(i+7);
	}

	
}
