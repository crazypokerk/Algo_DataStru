package leetcode.Top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date 2019/9/4 17:23
 */
public class _15_ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		
		for (int i = 0; i < nums.length - 2; i++) {
			if (i >= 1 && nums[i] == nums[i - 1]) {
				continue;
			}
			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				int sum = nums[l] + nums[r] + nums[i];
				if (sum == 0) {
					result.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
					while (l + 1 < r && nums[l] == nums[l + 1]) {
						l++;
					}
					while (r - 1 > l && nums[r] == nums[r - 1]) {
						r--;
					}
					l++;
					r--;
				} else if (sum > 0) {
					r--;
				} else {
					l++;
				}
			}
		}
		return result;
	}
	
}
