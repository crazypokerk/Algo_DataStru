package leetcode.Top;

/**
 * @Date 2019/9/4 9:16
 */
public class _242_IsAnagram {
	
	public static boolean isAnagram(String s, String t) {
		
		if (s.length() != t.length()) {
			return false;
		}
		int[] alpha = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alpha[s.charAt(i) - 'a']++;
			alpha[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (alpha[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "anagram";
		String t = "agranam";
		
		boolean anagram = isAnagram(s, t);
		System.out.println(anagram);
	}
	
}
