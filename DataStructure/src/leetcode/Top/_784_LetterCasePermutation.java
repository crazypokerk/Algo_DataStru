package leetcode.Top;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/9/14 11:01
 */
public class _784_LetterCasePermutation {
	public static List<String> letterCasePermutation(String S) {
		List<String> ans = new ArrayList<>();
		dfs(S.toCharArray(), 0, ans);
		return ans;
	}
	
	private static void dfs(char[] s, int i, List<String> ans) {
		if (i == s.length) {
			ans.add(String.valueOf(s));
			return;
		}
		
		dfs(s, i + 1, ans);
		if (s[i] < '0' || s[i] > '9') {
			s[i] ^= 1 << 5;
			dfs(s, i + 1, ans);
		}
	}
	
	public static void main(String[] args) {
		String S = "a2Ts3";
		List<String> list = letterCasePermutation(S);
		
		for (String s : list) {
			System.out.println(s);
		}
	}
}
