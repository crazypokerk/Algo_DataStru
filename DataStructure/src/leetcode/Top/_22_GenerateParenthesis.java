package leetcode.Top;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/9/5 14:47
 */
public class _22_GenerateParenthesis {
	
	public static List<String> generateParenthesis(int n) {
		
		List<String> ans = new ArrayList<>();
		
		backtrack(ans, "", n, n);
		
		return ans;
	}
	
	private static void backtrack(List<String> ans, String s, int left, int right) {
		if (left == 0 && right == 0) {
			ans.add(s);
			return;
		}
		
		if (left < 0 || right < 0 || left > right) return;
		backtrack(ans, s + "(", left - 1, right);
		backtrack(ans, s + ")", left, right - 1);
	}
	
	public static void main(String[] args) {
		int n = 3;
		
		List<String> list = generateParenthesis(3);
		for (String s : list) {
			System.out.println(s);
		}
	}
	
}
