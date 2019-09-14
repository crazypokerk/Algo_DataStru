package leetcode.Top;

/**
 * @Date 2019/9/14 15:58
 */
public class _485_FindMaxConsecutiveOnes {
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
				max = count;
			} else {
				max = Math.max(count, max);
				count = 0;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] n = {1, 0, 1, 1, 0, 1, 1, 1, 1, 1};
		System.out.println(findMaxConsecutiveOnes(n));
	}
}
