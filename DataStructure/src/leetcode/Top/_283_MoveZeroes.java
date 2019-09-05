package leetcode.Top;

/**
 * @Date 2019/9/4 14:13
 */
public class _283_MoveZeroes {
	
	public static int[] moveZeroes(int[] nums) {
		for (int i = 0, j = 0; i < nums.length && j < nums.length; i++) {
			if (nums[i] != 0) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				j++;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] a = {1};
		
		int[] ints = moveZeroes(a);
		for (int anInt : ints) {
			System.out.print(anInt);
		}
	}
}
