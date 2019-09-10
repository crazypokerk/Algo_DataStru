package leetcode.Top;

/**
 * @Date 2019/9/7 22:14
 */
public class _9_ {
	public boolean isPalindrome(int x) {
		//思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
		if (x < 0 || (x % 10 == 0 && x != 0)) return false;
		int revertedNumber = 0;
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x /= 10;
		}
		return x == revertedNumber || x == revertedNumber / 10;
	}
}
