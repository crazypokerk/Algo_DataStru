package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Date 2019/8/31 12:36
 */
public class _94_InorderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		
		TreeNode sentry = root;
		
		while (sentry != null || !stack.isEmpty()) {
			if (sentry != null) {
				stack.push(sentry);
				sentry = sentry.left;
			} else {
				sentry = stack.pop();
				res.add(sentry.val);
				sentry = sentry.right;
			}
		}
		return res;
	}
	
}
