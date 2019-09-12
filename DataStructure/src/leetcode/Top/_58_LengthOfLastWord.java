package leetcode.Top;

/**
 * @Date 2019/9/11 16:07
 */
public class _58_LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
		
		if (s == null) return 0;
		int first = s.length() - 1;
		while (first >= 0 && s.charAt(first) == ' ') first--;
		if (first < 0) return 0;
		int second = first;
		while (second >= 0 && s.charAt(second) == ' ') second--;
		return first - second;
	}
	
}
