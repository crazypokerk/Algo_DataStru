package leetcode.Top;

/**
 * @Date 2019/9/6 10:36
 */
public class _171_TitleToNumber {
	
	public int titleToNumber(String s) {
		
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - 'A' + 1;
			ans = ans * 26 + num;
		}
		
		return ans;
	}
	
}
