package leetcode.Top.dp;

import java.util.Map;

/**
 * @Date 2019/9/7 11:23
 */
public class _53_MaxSubArray {
	
	public int maxSubArray(int[] nums) {
		
		int res = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum > 0) {
				sum += sum;
			} else {
				sum = num;
			}
			res = Math.max(res, sum);
		}
		return res;
	}
	
}
