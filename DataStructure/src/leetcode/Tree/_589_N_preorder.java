package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Date 2019/8/31 15:06
 */
public class _589_N_preorder {
	
	public List<Integer> preorder(Node root) {
		
		Stack<Node> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		
		stack.push(root);
		
		while (!stack.isEmpty()) {
			Node tmp = stack.pop();
			list.add(tmp.val);
			
			// 从后向前取
			List<Node> nodes = tmp.children;
			for (int i = nodes.size() - 1; i >= 0; --i) {
				stack.push(nodes.get(i));
			}
		}
		
		return list;
	}
	
}
