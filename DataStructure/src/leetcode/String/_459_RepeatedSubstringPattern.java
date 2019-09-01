package leetcode.String;

/**
 * @Date 2019/9/1 14:49
 */
public class _459_RepeatedSubstringPattern {
	
	public static boolean repeatedSubstringPattern(String s) {
		
		String str = s + s;
		return str.substring(1, str.length() - 1).contains(s);
	}
	
	
	public static void main(String[] args) {
		String s = "abcab";
		
		boolean b = repeatedSubstringPattern(s);
		System.out.println(b);
	}
}
