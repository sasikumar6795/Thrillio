package com.sasi.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Cache {

	private BookMark[] items;

	private int next = 0;

	public Cache(int size) {
		items = new BookMark[size];
	}

	public void add(BookMark item) {
		items[next++] = item;
	}

	public CacheIterator iterator() {
		return new MyCacheIterator();
	}

	private class MyCacheIterator implements CacheIterator {
		private int i = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < items.length;
		}

		@Override
		public BookMark next() {
			// TODO Auto-generated method stub
			return items[i++];
		}

	}

	public static void main(String[] args)

	{
		Cache recommendedItems = new Cache(5);

		recommendedItems.add(new BookMark(1, "OneWhoKnocks", 4.5));
		recommendedItems.add(new BookMark(2, "Game", 4.3));
		recommendedItems.add(new BookMark(3, "You", 4.7));
		recommendedItems.add(new BookMark(4, "Fuck", 4.8));
		recommendedItems.add(new BookMark(5, "Yourself", 4.1));

		CacheIterator iterator = recommendedItems.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}

		Arrays.sort(recommendedItems.items, new Comparator<BookMark>() {

			@Override
			public int compare(BookMark o1, BookMark o2) {
				// TODO Auto-generated method stub
				return o1.getRating() < o2.getRating() ? 1 : -1;
			}

		});

		System.out.println("\nSorted by rating (using Anonymous class) ...");

		iterator = recommendedItems.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		
		Arrays.sort(recommendedItems.items, (o1, o2) ->   new Integer(o1.getTitle().length()).compareTo(new Integer(o2.getTitle().length())));
	//	Arrays.sort(recommendedItems.items, (BookMark o1, BookMark o2) -> {return new Integer( o1.getTitle().length()).compareTo(new Integer( o1.getTitle().length()));} );
		
		System.out.println("\nSorted by length (using Lambda) ...");
		iterator = recommendedItems.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		
		new Cache(5).go(() -> System.out.println("\nLambda"));
	}
	static int global = 0;
	public void go(Test test) {
		test.apply();
		
		int count =0;
		
		for (int i=0;i<5;i++)
		{
			new Thread(()-> System.out.println(count)).start();
			new Thread(()-> System.out.println(global++)).start();
		}
	}

}
