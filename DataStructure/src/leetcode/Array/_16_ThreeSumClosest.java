package leetcode.Array;

import java.util.Arrays;

/**
 * @Date 2019/8/27 14:48
 */
public class _16_ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		
		int result = nums[0] + nums[1] + nums[nums.length - 1];
		
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (Math.abs(target - sum) < Math.abs(target - result)) {
					result = sum;
				}
				if (sum > target) {
					end--;
				} else if (sum < target) {
					start++;
				} else {
					return result;
				}
			}
		}
		return result;
	}
}
