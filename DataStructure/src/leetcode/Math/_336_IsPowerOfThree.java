package leetcode.Math;

/**
 * @Date 2019/9/1 15:34
 */
public class _336_IsPowerOfThree {
	
	public boolean isPowerOfThree(int n) {
		
		while (n % 3 == 0) {
			n /= 3;
		}
		return n == 1;
	}
	
}
