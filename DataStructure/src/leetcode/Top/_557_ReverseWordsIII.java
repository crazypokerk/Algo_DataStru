package leetcode.Top;

import java.util.Stack;

/**
 * @Date 2019/9/14 15:31
 */
public class _557_ReverseWordsIII {
	
	public String reverseWords(String s) {
		
		String[] strs = s.split(" ");
		
		StringBuilder ans = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for (String str : strs) {
			for (int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
			}
			
			while (!stack.isEmpty()) {
				ans.append(stack.pop());
			}
			ans.append(" ");
		}
		return ans.toString().trim();
	}
	
}
