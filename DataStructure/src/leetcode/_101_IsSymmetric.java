package leetcode;


/**
 * @Date 2019/8/21 10:33
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		val = x;
	}
}

public class _101_IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
		return symmetric(root, root);
	}
	
	public boolean symmetric(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) return true;
		if (root1 == null || root2 == null) return false;
		if (root1.val != root2.val) return false;
		return symmetric(root1.left, root2.right) && symmetric(root1.right, root2.left);
	}
}
