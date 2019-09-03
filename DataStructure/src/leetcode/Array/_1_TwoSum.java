package leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/9/3 14:54
 */
public class _1_TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		
		if (nums.length < 2) return null;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int dev = target - nums[i];
			if (map.containsKey(dev)) {
				return new int[]{map.get(dev), i};
			} else {
				map.put(nums[i], i);
			}
		}
		return null;
	}
	
}
