package leetcode.Top;

/**
 * @Date 2019/9/13 9:20
 */
public class _5_LongestPalindrome {
	
	public static String longestPalindrome(String s) {
		
		String ans = "";
		int max = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				String test = s.substring(i, j);
				if (isPalindromic(test) && test.length() > max) {
					ans = s.substring(i, j);
					max = Math.max(max, ans.length());
				}
			}
		}
		return ans;
	}
	
	public static boolean isPalindromic(String s) {
		
		int l = 0, r = s.length() - 1;
		while (l <= r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String test = "babad";
		
		String s = longestPalindrome(test);
		System.out.println(s);
		
		//boolean palindromic = isPalindromic(test);
		//System.out.println(palindromic);
	}
	
}
