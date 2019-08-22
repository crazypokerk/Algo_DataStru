package leetcode;


/**
 * @Date 2019/8/21 15:01
 */
public class _104_MaxDepth {
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left_height = maxDepth(root.left);
			int right_height = maxDepth(root.right);
			return Math.max(left_height, right_height) + 1;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		int i = maxDepth(root);
		System.out.println(i);
	}
}
