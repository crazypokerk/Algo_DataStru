package leetcode.Array;

/**
 * @Date 2019/9/3 15:36
 */
public class _27_RemoveElement {
	
	public int removeElement(int[] nums, int val) {
		
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i++] = nums[j];
			}
		}
		return i;
	}
	
}
