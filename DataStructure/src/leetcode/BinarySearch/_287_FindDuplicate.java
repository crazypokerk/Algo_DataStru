package leetcode.BinarySearch;

/**
 * @Date 2019/8/30 9:16
 */
public class _287_FindDuplicate {
	
	public static int findDuplicate(int[] nums) {
		
		int left = 1, right = nums.length - 1;
		while (left < right) {
			int mid = left + ((right - left) >> 1);
			int count = 0;
			for (int num : nums) {
				if (num <= mid) {
					count++;
				}
			}
			
			if (count > mid) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		int[] n = {3, 1, 3, 4, 2};
		
		int duplicate = findDuplicate(n);
		System.out.println(duplicate);
	}
	
}
