package leetcode.Top100;

/**
 * @Date 2019/9/4 10:21
 */
public class _344_ReverseString {
	
	public String reverseString(char[] s) {
		
		int l = 0, r = s.length - 1;
		while (l < r) {
			swap(l++, r--, s);
		}
		return s.toString();
	}
	
	private void swap(int l, int r, char[] s) {
		char tmp = s[l];
		s[l] = s[r];
		s[r] = tmp;
	}
}
