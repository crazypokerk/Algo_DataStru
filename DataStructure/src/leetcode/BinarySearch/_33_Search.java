package leetcode.BinarySearch;

/**
 * @Date 2019/8/29 9:20
 */
public class _33_Search {
	
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] > nums[right]) left = mid + 1;
			else right = mid;
		}
		
		//.out.println(nums[left]);
		
		int split = left;
		left = 0;
		right = nums.length - 1;
		// 判断target值在左部分还是右部分
		if (nums[split] <= target && target <= nums[right]) {
			left = split;
		} else {
			right = split;
		}
		
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
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, -1, 0, 1, 2};
		
		int search = search(nums, 0);
		System.out.println(search);
	}
	
}
