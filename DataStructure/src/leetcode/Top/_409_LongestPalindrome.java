package leetcode.Top;


/**
 * @Date 2019/9/12 10:19
 */
public class _409_LongestPalindrome {
	
	public int longestPalindrome(String s) {
		
		int[] count = new int[128];
		for (char c : s.toCharArray()) {
			count[c]++;
		}
		
		int ans = 0, oddCount = 0;
		for (int i : count) {
			if (i % 2 == 0) {
				ans += i;
			} else {
				oddCount++;
				ans += i - 1;
			}
		}
		
		return oddCount > 0 ? ans + 1 : ans;
	}
	
}
