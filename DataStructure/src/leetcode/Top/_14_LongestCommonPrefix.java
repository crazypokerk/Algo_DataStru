package leetcode.Top;

/**
 * @Date 2019/9/5 16:13
 */
public class _14_LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		
		if (strs.length == 0) {
			return "";
		}
		String res = strs[0];
		for (int i = 0; i < strs.length; i++) {
			int j = 0;
			for (; j < res.length() && j < strs[i].length(); j++) {
				if (res.charAt(j) != strs[i].charAt(j)) {
					break;
				}
			}
			res = res.substring(0, j);
			if (res.equals("")) {
				return res;
			}
		}
		return res;
	}
	
}
