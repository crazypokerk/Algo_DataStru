package leetcode.Others;

/**
 * @Date 2019/8/28 9:29
 */
public class _69_MySqrt {
	public int mySqrt(int x) {
		if (x == 1 || x == 0) {
			return x;
		}
		
		// 一个数的平方根最大不会超过该数本身的一半
		int l = 1, r = x / 2 + 1;
		int mid = 0;
		while (l <= r) {
			mid = l + ((r - l) >> 2);
			// 防止越界
			if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
				return mid;
			}
			if (mid > x / mid) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return mid;
	}
}
