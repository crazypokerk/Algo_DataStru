package leetcode.BinarySearch;

/**
 * @Date 2019/8/29 10:44
 */
public class _35_SearchInsert {
	
	public int searchInsert(int[] nums, int target) {
		
		int left = 0, right = nums.length - 1;
		
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	
}
