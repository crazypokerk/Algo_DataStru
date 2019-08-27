package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/8/26 9:42
 */
public class _442_FindDuplicates {
	
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> bucket = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				bucket.add(nums[i]);
			}
		}
		
		return bucket;
	}
	
	public void swap(int[] n, int a, int b) {
		n[a] = n[a] ^ n[b];
		n[b] = n[a] ^ n[b];
		n[a] = n[a] ^ n[b];
	}
	
}
