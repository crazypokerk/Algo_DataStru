package leetcode.Top;

import java.util.HashSet;
import java.util.Set;

/**
 * @Date 2019/9/12 11:07
 */
public class _345_ReverseVowels {
	
	public String reverseVowels(String s) {
		
		if (s.length() < 1) return s;
		int l = 0, r = s.length() - 1;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			set.add('a');
			set.add('e');
			set.add('i');
			set.add('o');
			set.add('u');
			set.add('A');
			set.add('E');
			set.add('I');
			set.add('O');
			set.add('U');
		}
		char[] chars = s.toCharArray();
		while (l < r) {
			while (!set.contains(chars[l]) && l < r) l++;
			while (!set.contains(chars[r]) && l < r) r--;
			
			char tmp = chars[l];
			chars[l] = chars[r];
			chars[r] = tmp;
			
			l++;
			r--;
		}
		
		return String.valueOf(chars);
	}
}
