package leetcode.Top;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/9/9 21:03
 */
public class _3_LengthOfLongestSubstring {
	
	public int lengthOfLongestSubstring(String s) {
		int len = s.length(), max = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int end = 0, start = 0; end < len; end++) {
			char now = s.charAt(end);
			// 如果包含就更新start
			if (map.containsKey(now)) {
				start = Math.max(map.get(now), start);
			}
			max = Math.max(max, end - start + 1);
			map.put(s.charAt(end), end + 1);
		}
		return max;
	}
	
}
