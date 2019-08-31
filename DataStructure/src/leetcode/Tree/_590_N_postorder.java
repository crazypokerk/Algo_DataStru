package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Date 2019/8/31 15:27
 */
public class _590_N_postorder {
	
	public List<Integer> postorder(Node root) {
		Stack<Node> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		
		stack.push(root);
		
		while (!stack.isEmpty()) {
			Node now = stack.pop();
			list.add(0, now.val);
			
			for (Node child : now.children) {
				stack.push(child);
			}
		}
		return list;
	}
	
}
