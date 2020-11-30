package com.sasi.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo implements Iterable<Integer> {

	private static List<Integer> arrayListDemo() {
		/*
		 * Collection<Integer> list1 = new ArrayList<>(); list1.add(1); list1.add(2);
		 * list1.add(null); list1.add(2); System.out.println("collection" + list1);
		 * list1.remove(2); System.out.println("collection" + list1); list1.remove(2);
		 * System.out.println("collection" + list1);
		 */

		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(5);
		list2.add(null);
		list2.add(2);
		System.out.println("list" + list2);
		// specifying the index position
		list2.remove(3);
		System.out.println("list" + list2);
		list2.remove(2);
		System.out.println("list" + list2);
		list2.add(1, 24);
		System.out.println("list" + list2);
		list2.set(1, 26);
		System.out.println("list" + list2);

		Collection<Integer> list3 = new ArrayList<>();
		list3.add(25);
		list3.add(5);

		list2.removeAll(list3);
		System.out.println("After removing" + list2);
		list3.add(1);
		list2.retainAll(list3);
		System.out.println("after retaining" + list2);
		list2.addAll(list3);
		System.out.println("adding all" + list2);

		// search
		System.out.println("contains" + list2.contains(1));
		System.out.println("index of" + list2.indexOf(1));
		System.out.println("last index of " + list2.lastIndexOf(1));

		// range view
		System.out.println("before" + list2);
		List<Integer> list4 = list2.subList(2, 3);
		System.out.println(list4);
		list4.set(0, 6);
		System.out.println("after" + list2);
		list2.set(0, 55);
		System.out.println(list4);
		System.out.println(list2);
		/*
		 * list2.add(0,11); System.out.println(list4);
		 */

		// concurrent modification exception
		/*
		 * for (int element : list2) { System.out.println("Element:" + element); if
		 * (element == 6) { list2.remove(Integer.valueOf(element)); } }
		 * System.out.println(list2);
		 */
		/*
		 * for (int i = 0; i < list2.size(); i++) { System.out.println(list2.get(i));
		 * if(list2.get(i)==25) { list2.remove(list2.get(i)); } }
		 * System.out.println(list2);
		 */
		// implementing our own class as an iterator
		for (int element : new ListDemo()) {
			System.out.println("Element:" + element);
			if (element == 6) {
				list2.remove(Integer.valueOf(element));
			}
		}
		System.out.println(list2);
		return list2;
	}

	private static void iteratorDemo(List<Integer> list1) {
		System.out.println("inside iterator demo");
		System.out.println(list1);
		Iterator<Integer> iterator = list1.iterator();
		while (iterator.hasNext()) {
			int next = iterator.next();
			if (next == 25) {
				iterator.remove();
				iterator.forEachRemaining(Filter::add);
			}
		}
		System.out.println("iterator processing" + list1);
		list1.forEach(System.out::println);
		// list1.forEach(Filter::filter);
		list1.forEach(new Filter());
	}

	private static void listIteratorDemo() {
		System.out.println("inside list Iterator Demo");
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		System.out.println("display curret elements");
		for (ListIterator<String> iteration = list.listIterator(); iteration.hasNext();) {
			System.out.println(iteration.nextIndex() + iteration.next());
		}

		for (ListIterator<String> iterator = list.listIterator(); iterator.hasNext();) {
			System.out.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());

			if (iterator.nextIndex() == 1) {
				System.out.println("adding test at index 1");
				iterator.add("test");
				System.out
						.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());
				System.out.println("Removing test that was added at index 1");
				iterator.previous();
				iterator.previous();
				iterator.remove();
				System.out
						.println("iterator.nextIndex: " + iterator.nextIndex() + ", iterator.next: " + iterator.next());
				System.out.println("Setting element at index 1 as test");
				iterator.set("test");
				System.out.println(
						"Setting element at index 1 as test1 to show that two set operations can be invoked sequentially");
				iterator.set("test1");
			}
			System.out.println("display curret elements");
			for (ListIterator<String> iteration = list.listIterator(); iteration.hasNext();) {
				System.out.println(iteration.nextIndex() + iteration.next());
			}
		}

	}

	public static void main(String[] args) {
		List<Integer> list1 = arrayListDemo();
		iteratorDemo(list1);
		listIteratorDemo();
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new ArrayList().iterator();
	}

}
