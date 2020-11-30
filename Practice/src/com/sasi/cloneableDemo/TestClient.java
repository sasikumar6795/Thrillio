package com.sasi.cloneableDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestClient {
   public static int getVal() {
       return 42;
   }
 
   
   
   public static void main(String[] args) {
       C c = new X();
	   c.foo();
	   c.bar();
	   c.foobar();
	   ((X) c).get();
	   C clone = ((X)c).clone();
	   if (clone != c) {
	      System.out.println("Clone created!!");
	   }
	   
	   List<Integer> list = new ArrayList<Integer>();
	   list.add(11);
	   list.add(5);
	   list.add(9);
	   Collections.sort(list,Collections.reverseOrder());
	   for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
	}
   }
}