package Test;

import java.util.*;

/**
 * @Date 2019/5/27 14:03
 */
public class TestComparable {
	public static void main(String[] args) {
//    RainBow r1 = new RainBow(66, "a");
//    RainBow r2 = new RainBow(77, "b");
//    RainBow r3 = new RainBow(66, "c");
//    RainBow r4 = new RainBow(55, "d");
//
//    System.out.println(r1.compareTo(r2) + " " + r1.getAge() + r2.getAge());
//    System.out.println(r1.compareTo(r3) + " " + r1.getAge() + r3.getAge());
//    System.out.println(r2.compareTo(r4) + " " + r2.getAge() + r4.getAge());

//    ArrayList list = new ArrayList();
//    List list = new ArrayList();
//
//    list.add(1);
//    list.add(2);
//    List<Integer> list1 = new LinkedList<>(list);
//
//    System.out.println(list1);
		
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		
		map.get("A");
		map.get("a");
		map.size();
		
		System.out.println(map);
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}
		});
		
		PriorityQueue<String> priorityQueue1 = new PriorityQueue<>((String s1, String s2) -> {
			return s1.compareTo(s2) > 0 ? 1 : -1;
		});
		
	}
}
