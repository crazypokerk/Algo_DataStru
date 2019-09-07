package leetcode.Top;

/**
 * @Date 2019/9/7 10:40
 */
public class _172_TrailingZeroes {
	
	public int trailingZeroes(int n) {
		
		int res = 0;
		while (n > 0) {
			res += n / 5;
			n /= 5;
		}
		return res;
	}
	
}
