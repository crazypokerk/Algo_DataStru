package leetcode.Array;

/**
 * @Date 2019/9/3 15:26
 */
public class _26_RemoveDuplicates {
	
	public int removeDuplicates(int[] nums) {
		
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				nums[++i] = nums[j];
			}
		}
		return i + 1;
	}
	
}
