package leetcode.String;

/**
 * @Date 2019/9/1 14:24
 */
public class _541_ReverseStr_II {
	
	public String reverseStr(String s, int k) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i = i + 2 * k) {
			if (s.length() >= (i + k)) {
				sb.append(new StringBuilder(s.substring(i, i + k)).reverse());
			} else {
				sb.append(new StringBuilder(s.substring(i)).reverse());
				break;
			}
			
			if ((i + 2 * k) <= s.length()) {
				sb.append(s.substring(i + k, i + 2 * k));
			} else {
				sb.append(s.substring(i + k));
			}
		}
		return sb.toString();
	}
	
}
