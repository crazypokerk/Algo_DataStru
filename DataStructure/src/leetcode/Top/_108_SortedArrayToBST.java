package leetcode.Top;

/**
 * @Date 2019/9/5 11:20
 */
public class _108_SortedArrayToBST {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length);
	}
	
	private TreeNode helper(int[] nums, int left, int right) {
		
		if (left == right) {
			return null;
		}
		
		int mid = left + ((right - left) >>> 1);
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid);
		root.right = helper(nums, mid + 1, right);
		
		return root;
	}
	
}
