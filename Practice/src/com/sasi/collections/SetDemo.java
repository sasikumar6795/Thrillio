package com.sasi.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void hashsetDemo() {
		Set<String> set1 = new HashSet<String>();
		set1.add("a");
		set1.add("b");
		set1.add("a");
		System.out.println("set1 :" + set1);

		Book book1 = new Book("HalfGirlFriend", "ChetanBhagat", 2006);
		Book book2 = new Book("HalfGirlFriend", "ChetanBhagat", 2006);

		Set<Book> set2 = new HashSet<>();
		set2.add(book1);
		set2.add(book2);
		System.out.println("set2 :" + set2);
	}

	private static void treesetDemo() {
		Set<Book> books = new TreeSet<>(new TitleComparator());
		Book book1 = new Book("HalfGirlFriend", "ChetanBhagat", 2006);
		Book book2 = new Book("HalfGirlFriend", "ChetanBhagat", 2006);
		Book book3 = new Book("walden", "Hendry David", 1857);
		Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		
		for(Book book : books)
		{
			System.out.println(book);
		}
		
		

	}

	public static void main(String[] args) {
		 hashsetDemo();
		//treesetDemo();
	}

}
