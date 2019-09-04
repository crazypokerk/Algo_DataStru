package leetcode.Top100;

/**
 * @Date 2019/9/4 9:49
 */
public class _69_MySqrt {
	
	public int mySqrt(int x) {
		if (x == 1 || x == 0) {
			return x;
		}
		
		// 一个数的平方根最大不会超过该数本身的一半
		int l = 1, r = x >> 1, mid = 0;
		while (l < r) {
			mid = (l + r + 1) >>> 1;
			// 防止越界
			// x = mid * mid   mid = mid / x
			if (mid > x / mid) {
				r = mid - 1;
			} else {
				l = mid;
			}
		}
		return l;
	}
	
}
