package leetcode.Tree;

/**
 * @Date 2019/8/25 9:08
 */
public class _110_IsBalanced {
	
	public static boolean isBalanced(TreeNode root) {
		return depthHelper(root) != -1;
	}
	
	private static int depthHelper(TreeNode root) {
		if (root == null) return 0;
		
		int left = depthHelper(root.left);
		if (left == -1) return -1;
		int right = depthHelper(root.right);
		if (right == -1) return -1;
		
		return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		int i = depthHelper(root);
		System.out.println(i);
	}
}
