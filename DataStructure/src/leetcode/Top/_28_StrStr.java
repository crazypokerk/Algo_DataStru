package leetcode.Top;

/**
 * @Date 2019/9/5 15:39
 */
public class _28_StrStr {
	
	public static int strStr(String haystack, String needle) {
		
		return haystack.indexOf(needle);
	}
	
	public static void main(String[] args) {
		String a = "hello";
		String b = "ll";
		
		int i = strStr(a, b);
		System.out.println(i);
	}
	
}
