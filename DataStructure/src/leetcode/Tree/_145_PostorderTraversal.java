package leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Date 2019/8/31 16:20
 */
public class _145_PostorderTraversal {
	
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> output = new ArrayList<>();
		if (root == null) return output;
		
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode now = stack.pop();
			output.add(now.val);
			if (now.left != null) {
				stack.push(now.left);
			}
			if (now.right != null) {
				stack.push(now.right);
			}
		}
		Collections.reverse(output);
		return output;
	}
	
}
