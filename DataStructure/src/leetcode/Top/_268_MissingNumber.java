package leetcode.Top;

/**
 * @Date 2019/9/4 14:39
 */
public class _268_MissingNumber {
	
	public int missingNumber(int[] nums) {
		
		int[] arr = new int[nums.length + 1];
		
		for (int num : nums) {
			arr[num] = 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				return i;
			}
		}
		return 0;
	}
	
}
