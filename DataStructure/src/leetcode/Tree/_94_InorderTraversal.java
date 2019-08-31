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
		List<Integer> list = new ArrayList<>();
		
		TreeNode tmp = root;
		
		while (tmp != null && !stack.isEmpty()) {
			if (tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			} else {
				tmp = stack.pop();
				list.add(tmp.val);
				tmp = tmp.right;
			}
		}
		return list;
	}
	
}
