package leetcode.BinarySearch;

/**
 * @Date 2019/8/29 10:21
 */
public class _81_Search_II {
	
	public boolean search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
				left++;
				right--;
			} else if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return false;
	}
	
}
