package com.sasi.collections;

import java.rmi.server.SocketSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	private static void immutableKeysDemo() {
		System.out.println("\n immutable Demo");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		Map<List<Integer>, Integer> map = new HashMap<>();
		map.put(list, 1);
		System.out.println(map);
		list.add(2);
		System.out.println(map.get(list));

	}
	public static void LRUCacheTestDemo()
	{
		/*System.out.println("\n Inside LRU cachetest");
		Map<String, String> lruCache =  new LinkedHashMap<>(16, 0.75f, false);
		lruCache.put("a", "A");
		lruCache.put("b", "B");
		lruCache.put("c", "C");
		System.out.println(lruCache);
		lruCache.get("a");
		System.out.println(lruCache);
		lruCache.get("b");
		System.out.println(lruCache);
		lruCache.put("d", "D");
		System.out.println(lruCache);
		lruCache.put("e", "E");
		System.out.println(lruCache);*/
		
		
		/*System.out.println("\n Inside LRU cachetest");
		Map<String, String> lruCache =  new LinkedHashMap<>(16, 0.75f, true);
		lruCache.put("a", "A");
		lruCache.put("b", "B");
		lruCache.put("c", "C");
		System.out.println(lruCache);
		lruCache.get("a");
		System.out.println(lruCache);
		lruCache.get("b");
		System.out.println(lruCache);
		lruCache.put("d", "D");
		System.out.println(lruCache);
		lruCache.put("e", "E");
		System.out.println(lruCache);
		*/
		
		System.out.println("\n Inside LRU cachetest");
		Map<String, String> lruCache =  new LRUCache<>(16, 0.75f, true);
		lruCache.put("a", "A");
		lruCache.put("b", "B");
		lruCache.put("c", "C");
		System.out.println(lruCache);
		lruCache.get("a");
		System.out.println(lruCache);
		lruCache.get("b");
		System.out.println(lruCache);
		lruCache.put("d", "D");
		System.out.println(lruCache);
		lruCache.put("e", "E");
		System.out.println(lruCache);
		
	}
	public static void main(String[] args) {

		System.out.println("\n\nInside hashmap demo");
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("phorani", 25);
		map1.put("pavithra", 25);
		map1.put("Sowmiya", null);

		System.out.println(map1);

		map1.put("Sowmiya", 26);

		System.out.println("contains key:" + map1.containsKey("phorani"));
		System.out.println("phorani age:" + map1.get("phorani"));

		System.out.println("iterate through a map");

		System.out.println("iterating using keyset");
		Set<String> names = map1.keySet();
		for (String name : names) {
			System.out.println(name + ":" + map1.get(name));
		}

		System.out.println("iterating through entryset");
		Set<Map.Entry<String, Integer>> mappings = map1.entrySet();
		for (Map.Entry<String, Integer> mapping : mappings) {
			System.out.println(mapping.getKey() + ":" + mapping.getValue());
		}

		Map<String, Map<String, Object>> userProfiles = new HashMap<>();
		Map<String, Object> profile = new HashMap<>();
		profile.put("age", 27);
		profile.put("city", "NewYork");
		profile.put("dept", "CIVIL");

		userProfiles.put("Sasikumar", profile);

		profile = new HashMap<>();
		profile.put("age", 29);
		profile.put("city", "India");
		profile.put("dept", "CS");

		userProfiles.put("Shivani", profile);

		System.out.println("userprofiles: " + userProfiles);

		immutableKeysDemo();
		LRUCacheTestDemo();
	}

	class Student {
		int id;
		String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Student(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

	}
}
