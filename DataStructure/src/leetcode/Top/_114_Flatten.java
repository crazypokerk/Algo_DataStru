package leetcode.Top;

import java.util.Stack;

/**
 * @Date 2019/9/13 13:57
 */
public class _114_Flatten {
	
	public void flatten(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		TreeNode pre = null;
		
		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if (pre != null) {
				pre.right = tmp;
				pre.left = null;
			}
			if (tmp.right != null) {
				stack.push(tmp.right);
			}
			if (tmp.left != null) {
				stack.push(tmp.left);
			}
			
			pre = tmp;
		}
	}
	
}
