package leetcode.Top;


import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/9/4 15:59
 */
public class _217_ContainsDuplicate {
	
	public static boolean containsDuplicate(int[] nums) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return true;
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 1};
		
		boolean b = containsDuplicate(a);
		
		System.out.println(b);
	}
	
}
