package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Date 2019/4/27 13:45
 */
public class _15_3sum {
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3) {
			return Collections.emptyList();
		}
		// 主要思路：排好序的数组，是按大小递增的，所以用三个指针扫描一遍整个数组即可
		List<List<Integer>> res = new ArrayList<>();
		// 数组排序
		Arrays.sort(nums);
		
		//此处为什么要长度减2，因为还有两个数字要选择
		for (int i = 0; i < nums.length - 2; i++) {
			//如果有数字连续相等，就跳过本次循环
			if (i >= 1 && nums[i] == nums[i - 1]) {
				continue;
			}
			// i 从前扫描，j 从后扫描
			int left = i + 1;
			int right = nums.length - 1;
			
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (left + 1 < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (right - 1 > left && nums[right] == nums[right - 1]) {
						right--;
					}
					left++;
					right--;
				} else if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return res;
	}
}
