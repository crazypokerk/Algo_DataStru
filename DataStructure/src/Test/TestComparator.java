package Test;

import java.util.Comparator;

/**
 * @Date 2019/5/27 14:20
 */
public abstract class TestComparator {
	public static void main(String[] args) {
		Comparator<RainBow> comparator = (RainBow r1, RainBow r2) -> {
			if (r1.compareTo(r2) > 0) {
				return 1;
			} else if (r1.compareTo(r2) == 0) {
				return 0;
			} else {
				return -1;
			}
		};
		RainBow r1 = new RainBow(66, "a");
		RainBow r2 = new RainBow(77, "b");
		RainBow r3 = new RainBow(66, "c");
		RainBow r4 = new RainBow(55, "d");
		
		System.out.println(comparator.compare(r1, r2));
		System.out.println(comparator.compare(r1, r3));
		System.out.println(comparator.compare(r3, r4));
	}
	
}
