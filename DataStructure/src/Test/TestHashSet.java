package Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date 2019/8/15 13:27
 */
public class TestHashSet {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
		
		boolean a = set.add(123);
		boolean b = set.add(123);
		System.out.println(a);
		System.out.println(b);
	}
}
