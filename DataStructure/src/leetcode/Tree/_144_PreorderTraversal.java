package leetcode.Tree;

import java.util.*;

/**
 * @Date 2019/8/31 11:29
 */
public class _144_PreorderTraversal {
	
	public List<Integer> preorderTraversal(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> output = new ArrayList<>();
		if (root == null) return output;
		
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode now = stack.pop();
			output.add(now.val);
			if (now.right != null) {
				stack.push(now.right);
			}
			if (now.left != null) {
				stack.push(now.left);
			}
			
		}
		
		return output;
	}
}