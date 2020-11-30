package com.sasi.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

	public static void sequential()
	{
		String[] strArray =  new String[] {"Anita","Raj"};
		List<String> strings =  Arrays.asList(strArray); //fixed-size
		System.out.println(strings);
		//strings.remove(0);
		strings.set(0, "sasi");
		System.out.println(Arrays.toString(strArray));
		//if contents need to be modified
		strings =  new ArrayList<>(Arrays.asList(strArray));
		strings.add("abhi");
		System.out.println(strings);
		// this is not possible as primitive cannot be converted by autoboxing
		//List<Integer> list = Arrays.asList(new int[3]);
		List<int[]> list = Arrays.asList(new int[3]);
		System.out.println("size: "+list.size());
		
		int[] ar =  new int[]{1,2,4,5,77,98,366,1213,35};
		int[] newar =  Arrays.copyOf(ar, 21);
		System.out.println(Arrays.toString(newar));
		
		int[] newarray1 =  new int[21];
		System.arraycopy(ar, 0, newarray1, 0, ar.length);
		System.out.println(Arrays.toString(newarray1));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sequential();
	}

}
