package leetcode.Top;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/9/5 14:31
 */
public class _387_FirstUniqChar {
	
	public int firstUniqChar(String s) {
		
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
	
}
