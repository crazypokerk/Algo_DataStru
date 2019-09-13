package leetcode.Top;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/9/11 12:51
 */
public class _93_RestoreIpAddresses {
	
	public static List<String> restoreIpAddresses(String s) {
		
		List<String> ans = new ArrayList<>();
		
		int n = s.length();
		
		backtrack(0, "", 4, s, ans, n);
		
		return ans;
	}
	
	private static void backtrack(int i, String tmp, int flag, String s, List<String> ans, int n) {
		if (i == n && flag == 0) {
			ans.add(tmp.substring(0, tmp.length() - 1));
			return;
		}
		if (flag < 0) return;
		for (int j = i; j < i + 3; j++) {
			if (j < n) {
				if (i == j && s.charAt(j) == '0') {
					backtrack(j + 1, tmp + s.charAt(j) + ".", flag - 1, s, ans, n);
					break;
				}
				if (Integer.parseInt(s.substring(i, j + 1)) <= 255) {
					backtrack(j + 1, tmp + s.substring(i, j + 1) + ".", flag - 1, s, ans, n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "25525511135";
		List<String> list = restoreIpAddresses(s);
		
		for (String s1 : list) {
			System.out.println(s1);
		}
	}
	
}
