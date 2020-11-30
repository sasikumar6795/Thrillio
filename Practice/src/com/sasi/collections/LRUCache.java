package com.sasi.collections;

import java.util.LinkedHashMap;
import java.util.Map;


//custom class 

//using super class constructor for intialization
// if the size is greater tha the max entries then delete the remove eldest entry, applying LRUCache,
// by defautl the removeEldestEntry will return false
public class LRUCache<K, V>  extends LinkedHashMap<K, V>{
	
	private static final int MAX_ENTRIES = 3;
	
	public LRUCache(int intialCapacity, float loadFactor, boolean accessOrder)
	{
		super(intialCapacity, loadFactor, accessOrder);
	}
	
	protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        if(size() > MAX_ENTRIES)
        {
        	return true;
        }
        return false;
    }
}
