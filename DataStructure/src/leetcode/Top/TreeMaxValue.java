package leetcode.Top;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Date 2019/9/8 16:45
 */
public class TreeMaxValue {
	
	public static int treeMaxValue(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) return 0;
		
		stack.push(root);
		
		while (!stack.isEmpty()) {
			int size = stack.size();
			
			for (int i = 0; i < size; i++) {
				TreeNode tmp = stack.pop();
				res.add(tmp.val);
				if (tmp.right != null) {
					stack.add(tmp.right);
				}
				if (tmp.left != null) {
					stack.add(tmp.left);
				}
			}
		}
		
		Collections.sort(res);
		return res.get(0);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(98);
		root.left = new TreeNode(92);
		root.right = new TreeNode(70);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(77);
		
		int i = treeMaxValue(root);
		
		System.out.println(i);
	}
}
