package Test;

import java.util.HashMap;

/**
 * @Date 2019/5/28 19:44
 */
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put(null, 1);
		map.put(null, 2);
		map.put(null, 3);
		System.out.println(map);

//    for (Integer value : map.values()) {
//      System.out.println(value);
//    }
	}
}
