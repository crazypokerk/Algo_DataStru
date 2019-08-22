package leetcode;

/**
 * @Date 2019/8/22 15:24
 */
public class _108_SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length);
	}
	
	private TreeNode helper(int[] nums, int start, int end) {
		if (start == end) return null;
		int mid_root = (start + end) >> 1;
		TreeNode root = new TreeNode(nums[mid_root]);
		
		root.left = helper(nums, start, mid_root);
		root.right = helper(nums, mid_root + 1, end);
		
		return root;
	}
}
