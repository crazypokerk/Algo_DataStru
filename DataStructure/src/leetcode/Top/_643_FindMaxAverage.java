package leetcode.Top;

/**
 * @Date 2019/9/14 12:42
 */
public class _643_FindMaxAverage {
	
	public static double findMaxAverage(int[] nums, int k) {
		if (nums.length < k) return 0;
		double max = 0;
		for (int i = 0; i < nums.length - k + 1; i++) {
			double cur = 0;
			for (int j = i; j < k + i; j++) {
				cur += nums[j];
			}
			max = Math.max(max, cur);
		}
		return max / k;
	}
	
	public static void main(String[] args) {
		int[] nums = {5};
		int k = 1;
		double maxAverage = findMaxAverage(nums, k);
		System.out.println(maxAverage);
		
	}
}
