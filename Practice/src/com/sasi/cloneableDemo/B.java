package com.sasi.cloneableDemo;
public interface B {
   int VAL = TestClient.getVal();
   void foo();
   default void get()
   {
	   System.out.println("B.get");
   }
}