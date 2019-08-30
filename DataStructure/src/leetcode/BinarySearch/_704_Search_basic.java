package leetcode.BinarySearch;

/**
 * @Date 2019/8/30 14:30
 */
public class _704_Search_basic {
	
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + ((right - left) >>> 1);
			if (target > nums[mid]) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		
		return nums[left] == target ? left : -1;
	}
	
}
