package com.sasi.collections;

import java.util.Comparator;

public class TitleComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return ((Book)o1).getTitle().compareTo(((Book)o2).getTitle());
	}

}
