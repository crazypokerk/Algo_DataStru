package leetcode.String;

/**
 * @Date 2019/9/1 14:36
 */
public class _520_DetectCapitalUse {
	
	public boolean detectCapitalUse(String word) {
		int low = 0, high = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'a') {
				low++;
			} else {
				high++;
			}
		}
		
		
		if (low == word.length() || high == word.length() || (high == 1 && low == word.length() - 1 && word.charAt(0) < 'a')) {
			return true;
		} else {
			return false;
		}
	}
	
}
